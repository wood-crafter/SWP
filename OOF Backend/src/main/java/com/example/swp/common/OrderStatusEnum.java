package com.example.swp.common;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    DELIVERING(0, "Delivering"),
    COMPLETED(1, "Completed");

    private Integer id;

    private String message;

    OrderStatusEnum(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

}
