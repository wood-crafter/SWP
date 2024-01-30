package com.example.swp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
//    private List<Product> products;

}
