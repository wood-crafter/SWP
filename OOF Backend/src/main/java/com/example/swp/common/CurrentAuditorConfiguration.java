package com.example.swp.common;

import com.example.swp.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class CurrentAuditorConfiguration implements AuditorAware<Float> {
    @Override
    public Optional<Float> getCurrentAuditor() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(user.getId());
    }
}
