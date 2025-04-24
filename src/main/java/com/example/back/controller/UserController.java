package com.example.back.controller;

import com.example.back.common.Result;
import com.example.back.controller.dto.LoginDTO;
import com.example.back.controller.request.LoginRequest;
import com.example.back.controller.request.RegisterRequest;
import com.example.back.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    //登录接口
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        LoginDTO loginDTO = userService.login(loginRequest);
        return Result.success(loginDTO);
    }

    //查询用户
    @GetMapping("/find")
    public Result findUser(@RequestParam String phone){
        return Result.success(userService.findByPhone(phone));
    }

    @PostMapping("/register")
    public Result register(@RequestBody RegisterRequest registerRequest) {
        return Result.success(userService.register(registerRequest));
    }
}

