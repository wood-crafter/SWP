package com.example.swp.custom_repository;

import com.example.swp.dto.OrderDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderCustomRepository {
    @Autowired
    private EntityManager entityManager;

    public List<OrderDto> findByUserId(Float userId) {
        String sql = "select id as orderId, status from orders where user_id = :userId" +
                " order by status asc, created_date desc";
        Query query = entityManager.createNativeQuery(sql, "OrderDto");
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
