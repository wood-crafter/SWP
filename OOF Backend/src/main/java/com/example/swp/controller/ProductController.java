package com.example.swp.controller;

import com.example.swp.common.BaseResponse;
import com.example.swp.common.ResponseCodeEnum;
import com.example.swp.dto.ProductDto;
import com.example.swp.entity.Product;
import com.example.swp.entity.Comment;
import com.example.swp.entity.User;
import com.example.swp.repository.ProductRepository;
import com.example.swp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepo;

    @PostMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Float id, @RequestParam("description") String description) {
        Product product = productRepo.findById(id).get();
        product.setDescription(description);
        productRepo.save(product);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<ProductDto>>> getProduct(
            @RequestParam(name = "categoryId", required = false) Integer categoryId,
            @RequestParam(name = "supplierId", required = false) Integer supplierId,
            @RequestParam(name = "searchText", required = false) String searchText,
            @RequestParam(name = "minPrice", required = false) Float minPrice,
            @RequestParam(name = "maxPrice", required = false) Float maxPrice
    ) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(productService.findAll(categoryId, supplierId, searchText, minPrice, maxPrice)));
        } catch (Exception e) {
            log.error("Get product: " + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<BaseResponse<Product>> productDetail(@PathVariable Float productId) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(productService.findById(productId)));
        } catch (Exception e) {
            log.error("Get product detail: " + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }

    @PostMapping("/comment")
    public ResponseEntity comment(@AuthenticationPrincipal User user, @RequestBody Comment comment) {
        try {
            productService.comment(user, comment);
            return ResponseEntity.ok(BaseResponse.ok(ResponseCodeEnum.OK.getMessage()));
        } catch (Exception e) {
            log.error("Comment: " + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }
}
