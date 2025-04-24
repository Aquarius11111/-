package com.example.back.service;

import com.example.back.controller.dto.LoginDTO;
import com.example.back.controller.request.LoginRequest;
import com.example.back.controller.request.RegisterRequest;
import com.example.back.dao.User;

public interface IUserService {
    LoginDTO login(LoginRequest request);

    LoginDTO register(RegisterRequest registerRequest);

    boolean findByPhone(String phone);

}
