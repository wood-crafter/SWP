package com.example.swp.repository;

import com.example.swp.entity.Order;
import com.example.swp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Float> {
    List<Order> findAllByUserOrderByStatusAscCreatedDateDesc(User user);
}
