package com.example.swp.controller;

import com.example.swp.common.BaseResponse;
import com.example.swp.common.ResponseCodeEnum;
import com.example.swp.dto.OrderWithOrderProductDto;
import com.example.swp.entity.Order;
import com.example.swp.entity.User;
import com.example.swp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Slf4j
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(
            @AuthenticationPrincipal User user,
            @RequestBody List<Float> cartsId) {
        try {
            orderService.createOrder(user, cartsId);
            return ResponseEntity.ok(ResponseCodeEnum.OK.getMessage());
        } catch (Exception e) {
            log.error("Create Order: " + e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<OrderWithOrderProductDto>>> getOrders(@AuthenticationPrincipal User user) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(orderService.findAll(user)));
        } catch (Exception e) {
            log.error("Get Order: " + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<List<Order>>> getOrderDetail(@PathVariable Float id) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(orderService.findById(id)));
        } catch (Exception e) {
            log.error("Get Order Detail: " + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }
}
