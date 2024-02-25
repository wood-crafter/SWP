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

    private final String SQL_HOT_QUERY = "SELECT " +
            "    p.id AS id," +
            "    p.name AS productName," +
            "    p.price AS price," +
            "    p.path AS imagePath," +
            "    CASE" +
            "        WHEN p.status = 1 THEN 'Active'" +
            "        ELSE 'Inactive'" +
            "    END AS status," +
            "    p.description AS description," +
            "    c.name AS categoryName," +
            "    s.name AS supplierName" +
            " FROM" +
            "    (SELECT " +
            "        product_stocktaking_id, SUM(quantity) AS total_quantity" +
            "    FROM" +
            "        order_product" +
            "    WHERE" +
            "        TIMESTAMPDIFF(DAY, created_date, NOW()) <= 30" +
            "    GROUP BY product_stocktaking_id" +
            "    ORDER BY total_quantity DESC" +
            "    LIMIT 10) t1" +
            "        INNER JOIN" +
            "    product_stocktaking ps ON ps.id = t1.product_stocktaking_id" +
            "        INNER JOIN" +
            "    products p ON p.id = ps.product_id" +
            "        INNER JOIN" +
            "    categories c ON p.category_id = c.id" +
            "        INNER JOIN" +
            "    suppliers s ON p.supplier_id = s.id";
    
    private final String SQL_NEW_QUERY = "SELECT " +
            "    p.id AS id," +
            "    p.name AS productName," +
            "    p.price AS price," +
            "    p.path AS imagePath," +
            "    CASE" +
            "        WHEN p.status = 1 THEN 'Active'" +
            "        ELSE 'Inactive'" +
            "    END AS status," +
            "    p.description AS description," +
            "    c.name AS categoryName," +
            "    s.name AS supplierName" +
            " FROM" +
            "    products p" +
            "        INNER JOIN" +
            "    categories c ON p.category_id = c.id" +
            "        INNER JOIN" +
            "    suppliers s ON p.supplier_id = s.id" +
            " WHERE" +
            "    c.name = :categoryName" +
            " ORDER BY id DESC" +
            " LIMIT :pageCount OFFSET :offset";

    private final Integer PAGE_COUNT = 10;

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

    public List<ProductDto> getHots() {
        Query query = entityManager.createNativeQuery(SQL_HOT_QUERY, "ProductDto");
        return query.getResultList();
    }

    public List<ProductDto> getNew(Integer page, String categoryName) {
        Query query = entityManager.createNativeQuery(SQL_NEW_QUERY, "ProductDto");
        query.setParameter("categoryName", categoryName);
        query.setParameter("pageCount", PAGE_COUNT);
        query.setParameter("offset", PAGE_COUNT * (page - 1));
        return query.getResultList();
    }
}
