package com.example.swp.repository;

import com.example.swp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Float> {
    User findByUsername(String username);
}
