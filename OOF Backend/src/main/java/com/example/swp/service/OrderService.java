package com.example.swp.service;

import com.example.swp.dto.OrderWithOrderProductDto;
import com.example.swp.entity.Order;
import com.example.swp.entity.User;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, List<Float> cartIds);

    List<OrderWithOrderProductDto> findAll(User user);

    Order findById(Float id);
}
