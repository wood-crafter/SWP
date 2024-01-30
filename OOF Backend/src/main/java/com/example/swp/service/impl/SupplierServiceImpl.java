package com.example.swp.service.impl;

import com.example.swp.entity.Supplier;
import com.example.swp.repository.SupplierRepository;
import com.example.swp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepo;

    @Override
    public List<Supplier> findAll() {
        return supplierRepo.findAll();
    }
}
