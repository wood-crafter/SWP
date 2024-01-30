package com.example.swp.service;

import com.example.swp.entity.User;

public interface AuthService {

    User validateUser(User user);

    User save(User user);

    User findByUsername(String username);
}
