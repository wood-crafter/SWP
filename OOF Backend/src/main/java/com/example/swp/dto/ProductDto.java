package com.example.swp.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String productName;
    private String imagePath;
    private Float price;
    private String status;
    private String description;
    private String categoryName;
    private String supplierName;
}
