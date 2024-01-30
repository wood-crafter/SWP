package com.example.swp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "banners")
public class Banner extends BaseEntity {
    @Column(name = "path")
    private String path;
}
