package com.example.swp.service.impl;

import com.example.swp.entity.Banner;
import com.example.swp.repository.BannerRepository;
import com.example.swp.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepo;

    @Override
    public List<Banner> findAll() {
        return bannerRepo.findAll();
    }

}
