package com.example.swp.custom_repository;

import com.example.swp.dto.OrderProductDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderProductCustomRepository {

    @Autowired
    private EntityManager entityManager;

    public List<OrderProductDto> findByOrderId(Float orderId) {
        String sql = "SELECT " +
                "    p.name AS productName," +
                "    p.path," +
                "    c.name AS categoryName," +
                "    s.name AS supplierName," +
                "    op.quantity," +
                "    unit_price AS unitPrice" +
                " FROM" +
                "    order_product op" +
                "        INNER JOIN" +
                "    product_stocktaking ps ON op.product_stocktaking_id = ps.id" +
                "        INNER JOIN" +
                "    products p ON p.id = ps.product_id" +
                "        INNER JOIN" +
                "    categories c ON c.id = p.category_id" +
                "        INNER JOIN" +
                "    suppliers s ON s.id = p.supplier_id" +
                " WHERE" +
                "    order_id = :orderId";
        Query query = entityManager.createNativeQuery(sql, "OrderProductDto");
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }
}
