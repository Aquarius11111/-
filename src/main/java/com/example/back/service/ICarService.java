package com.example.back.service;

import com.example.back.controller.dto.LoginDTO;
import com.example.back.controller.request.LoginRequest;
import com.example.back.controller.request.RegisterRequest;

public interface ICarService {

    boolean findCar(String account);
}
