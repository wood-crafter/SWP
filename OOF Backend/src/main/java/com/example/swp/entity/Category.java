package com.example.swp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    private List<Product> products;

}
