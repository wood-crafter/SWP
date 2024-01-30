package com.example.swp.service;

import com.example.swp.entity.Cart;
import com.example.swp.entity.User;

import java.util.List;

public interface CartService {
    Cart insert(User user, Cart cart);

    List<Cart> getCart(User user);

    void delete(List<Float> cartIds);
}
