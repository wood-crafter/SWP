package com.example.swp.controller;

import com.example.swp.common.BaseResponse;
import com.example.swp.entity.Banner;
import com.example.swp.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/banners")
@Slf4j
@CrossOrigin
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("")
    public ResponseEntity<BaseResponse<List<Banner>>> findAll() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(bannerService.findAll()));
        } catch (Exception e) {
            log.error("Find all banners: " + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }
}
