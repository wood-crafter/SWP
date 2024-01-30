package com.example.swp.service.impl;

import com.example.swp.common.Converter;
import com.example.swp.common.ErrorMessageEnum;
import com.example.swp.entity.User;
import com.example.swp.repository.UserRepository;
import com.example.swp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User validateUser(User user) {
        if (user != null && StringUtils.hasText(user.getUsername())) {
            User realUser = userRepo.findByUsername(user.getUsername());
            if (passwordEncoder.matches(CharBuffer.wrap(user.getPassword()), realUser.getPassword())) {
//                realUser.getRole().setUsers(new ArrayList<>());
//                realUser.setCarts(new ArrayList<>());
                return realUser;
            }
        }
        throw new RuntimeException(ErrorMessageEnum.LOGIN_FAILED.getCode());
    }

    @Override
    public User findByUsername(String username) {
        if (StringUtils.hasText(username)) {
            return userRepo.findByUsername(username);
        }
        throw new RuntimeException(ErrorMessageEnum.TOKEN_INVALID.getCode());
    }

    @Override
    public User save(User user) {
        if (Arrays.asList(user.getFullname(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getEmail()).stream().allMatch(StringUtils::hasText)
                && user.getGender() != null
                && user.getDob() != null
                && user.getRole().getId() != null) {
            List<String> names = Arrays.asList(Converter.removeAccent(user.getFullname().trim().toLowerCase()).split(" "));
            StringBuilder username = new StringBuilder(names.get(names.size() - 1));
            for (int i = 0; i < names.size() - 1; i++) {
                username.append(names.get(i).charAt(0));
            }
            boolean isExist = true;
            while (isExist) {
                Random random = new Random();
                String usernameEnd = username.append(random.nextInt(100)).toString();
                isExist = userRepo.findByUsername(usernameEnd) != null;
                if (!isExist) {
                    user.setUsername(usernameEnd);
                }
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepo.save(user);
        }
        throw new RuntimeException(ErrorMessageEnum.LACK_OF_INFORMATION.getCode());
    }
}
