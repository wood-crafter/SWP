package com.example.swp.controller;

import com.example.swp.common.BaseResponse;
import com.example.swp.common.ErrorMessageEnum;
import com.example.swp.config.UserAuthProvider;
import com.example.swp.constants.RequestMappingConstant;
import com.example.swp.entity.User;
import com.example.swp.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserAuthProvider userAuthProvider;

    @GetMapping("/me")
    public ResponseEntity<BaseResponse<String>> me(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(BaseResponse.ok(user));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<BaseResponse<String>> signIn(@AuthenticationPrincipal User user) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(userAuthProvider.createToken(user.getUsername())));
        } catch (Exception e) {
            log.error(RequestMappingConstant.SIGN_IN_API + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<BaseResponse<String>> signUp(@RequestBody User user) {
        try {
            return ResponseEntity.ok(BaseResponse.ok(authService.save(user)));
        } catch (Exception e) {
            log.error(RequestMappingConstant.SIGN_IN_API + e);
            return ResponseEntity.badRequest().body(BaseResponse.fail(ErrorMessageEnum.typeOf(e.getMessage()).getMessage()));
        }
    }
}
