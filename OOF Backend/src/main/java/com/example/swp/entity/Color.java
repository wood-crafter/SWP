package com.example.swp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "colors")
public class Color extends BaseEntity{
    private String name;

    private String path;
}
