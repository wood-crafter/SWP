package com.example.swp.controller;

import com.example.swp.common.BaseResponse;
import com.example.swp.entity.Category;
import com.example.swp.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Slf4j
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Category>>> findAll() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(categoryService.findAll()));
        } catch (Exception e) {
            log.error("Find all categories: " + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }
}
