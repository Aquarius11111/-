package com.example.back.controller.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String account;
    private String password;
}
