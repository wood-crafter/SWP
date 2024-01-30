package com.example.swp.service;

import com.example.swp.dto.ProductDto;
import com.example.swp.entity.Comment;
import com.example.swp.entity.Product;
import com.example.swp.entity.User;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll(Integer categoryId, Integer supplierId, String searchText, Float minPrice, Float maxPrice);

    Product findById(Float productId);

    void comment(User user, Comment rate);
}
