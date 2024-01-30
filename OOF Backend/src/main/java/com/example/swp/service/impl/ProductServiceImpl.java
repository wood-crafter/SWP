package com.example.swp.service.impl;

import com.example.swp.custom_repository.ProductCustomRepository;
import com.example.swp.dto.ProductDto;
import com.example.swp.entity.Comment;
import com.example.swp.entity.Product;
import com.example.swp.entity.User;
import com.example.swp.repository.CommentRepository;
import com.example.swp.repository.ProductRepository;
import com.example.swp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductCustomRepository productCustomRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CommentRepository commentRepo;

    @Override
    public List<ProductDto> findAll(Integer categoryId, Integer supplierId, String searchText, Float minPrice, Float maxPrice) {
        return productCustomRepo.findAll(categoryId, supplierId, searchText, minPrice, maxPrice);
    }

    @Override
    public Product findById(Float productId) {
        return productRepo.findById(productId).map(x -> {
//            x.getCategory().setProducts(new ArrayList<>());
//            x.getSupplier().setProducts(new ArrayList<>());
            x.getProductStocktaking().stream().map(p -> {
                p.setProduct(null);
                return p;
            }).collect(Collectors.toList());
            x.getComments().stream().map(r -> {
                r.setProduct(null);
                return r;
            }).toList();
            return x;
        }).get();
    }

    @Override
    @Transactional
    public void comment(User user, Comment rate) {
        rate.setCommentator(user.getFullname());
        commentRepo.save(rate);
    }
}
