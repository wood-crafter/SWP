package com.example.swp.custom_repository;

import com.example.swp.dto.ProductDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class ProductCustomRepository {

    @Autowired
    private EntityManager entityManager;

    private String SQL_QUERY = "select p.id as id," +
            " p.name as productName," +
            " p.price as price," +
            " p.path as imagePath," +
            " case when p.status = 1 then \"Active\" else \"Inactive\" end as status," +
            " p.description as description," +
            " c.name as categoryName," +
            " s.name as supplierName" +
            " from products p" +
            " inner join categories c" +
            " on p.category_id = c.id" +
            " inner join suppliers s" +
            " on p.supplier_id = s.id";

    public List<ProductDto> findAll(Integer categoryId, Integer supplierId, String searchText, Float minPrice, Float maxPrice) {
        String conditionQuery = createCondition(categoryId, supplierId, searchText, minPrice, maxPrice);
        Query query = entityManager.createNativeQuery(SQL_QUERY + conditionQuery, "ProductDto");
        if (categoryId != null) {
            query.setParameter("categoryId", categoryId);
        }
        if (supplierId != null) {
            query.setParameter("supplierId", supplierId);
        }
        if (StringUtils.hasText(searchText)) {
            searchText = "%" + searchText + "%";
            query.setParameter("searchText", searchText);
        }
        if (minPrice != null) {
            query.setParameter("minPrice", minPrice);
        }
        if (maxPrice != null) {
            query.setParameter("maxPrice", maxPrice);
        }
        return query.getResultList();
    }

    private String createCondition(Integer categoryId, Integer supplierId, String searchText, Float minPrice, Float maxPrice) {
        String conditionQuery = "";
        if (categoryId != null) {
            conditionQuery += " and c.id = :categoryId";
        }
        if (supplierId != null) {
            conditionQuery += " and s.id = :supplierId";
        }
        if (StringUtils.hasText(searchText)) {
            conditionQuery += " and (p.name like :searchText" +
                    " or c.name like :searchText" +
                    " or s.name like :searchText)";
        }
        if (minPrice != null) {
            conditionQuery += " and p.price >= :minPrice";
        }
        if (maxPrice != null) {
            conditionQuery += " and p.price <= :maxPrice";
        }
        return StringUtils.hasText(conditionQuery)
                ? " where" + conditionQuery.substring(4)
                : conditionQuery;
    }

}
