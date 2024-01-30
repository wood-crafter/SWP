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
        String sql = "select p.name as productName," +
                " p.path," +
                " c.name as categoryName," +
                " s.name as supplierName," +
                " op.quantity," +
                " unit_price as unitPrice" +
                " from order_product op" +
                " inner join product_size ps" +
                " on op.product_size_id = ps.id" +
                " inner join products p" +
                " on p.id = ps.product_id" +
                " inner join categories c" +
                " on c.id = p.category_id" +
                " inner join suppliers s" +
                " on s.id = p.supplier_id" +
                " where order_id = :orderId";
        Query query = entityManager.createNativeQuery(sql, "OrderProductDto");
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }
}
