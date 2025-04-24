package com.example.back.dao;

import lombok.Data;

@Data
public class User {
    private String account;
    private String phone;
    private String password;
    private String email;
}
