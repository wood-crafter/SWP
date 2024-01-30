package com.example.swp.common;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {

    OK("200", "Successfully"),
    FAILED("400", "Bad Request"),
    UNAUTHENTICATION("401", "UnAuthentication");

    private String code;

    private String message;

    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
