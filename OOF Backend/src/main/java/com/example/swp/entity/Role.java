package com.example.swp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//    private List<User> users;
}
