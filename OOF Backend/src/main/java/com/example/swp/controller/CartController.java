package com.example.swp.controller;

import com.example.swp.common.BaseResponse;
import com.example.swp.common.ResponseCodeEnum;
import com.example.swp.entity.Cart;
import com.example.swp.entity.User;
import com.example.swp.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@Slf4j
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@AuthenticationPrincipal User user, @RequestBody Cart cart) {
        try {
            cartService.insert(user, cart);
            return ResponseEntity.ok(ResponseCodeEnum.OK.getMessage());
        } catch (Exception e) {
            log.error("Add Product to cart: " + e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Cart>>> cart(@AuthenticationPrincipal User user) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(cartService.getCart(user)));
        } catch (Exception e) {
            log.error("Get Cart: " + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> cart(@RequestBody List<Float> cartIds) {
        try {
            cartService.delete(cartIds);
            return ResponseEntity.ok(ResponseCodeEnum.OK.getMessage());
        } catch (Exception e) {
            log.error("Delete Cart: " + e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
