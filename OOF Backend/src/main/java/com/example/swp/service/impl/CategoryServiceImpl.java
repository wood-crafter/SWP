package com.example.swp.service.impl;

import com.example.swp.entity.Category;
import com.example.swp.repository.CategoryRepository;
import com.example.swp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll().stream().map(x -> {
//            x.getProducts().stream().map(p -> {
//                p.setCategory(null);
//                p.setProductSizes(null);
//                p.getSupplier().setProducts(null);
//                return p;
//            }).toList();
            return x;
        }).toList();
    }
}
