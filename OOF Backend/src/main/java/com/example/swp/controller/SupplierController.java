package com.example.swp.controller;

import com.example.swp.common.BaseResponse;
import com.example.swp.entity.Supplier;
import com.example.swp.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Slf4j
@CrossOrigin
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Supplier>>> findAll() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(supplierService.findAll()));
        } catch (Exception e) {
            log.error("Get All supplier:" + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }
}
