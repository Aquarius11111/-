package com.example.back.controller.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String phone;
    private String password;
}
