package com.example.back.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.back.controller.dto.LoginDTO;
import com.example.back.controller.request.LoginRequest;
import com.example.back.controller.request.RegisterRequest;
import com.example.back.dao.User;
import com.example.back.exception.ServiceException;
import com.example.back.mapper.UserMapper;
import com.example.back.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    private static final String PASS_SALT = "champion";

    @Override
    public LoginDTO login(LoginRequest request) {
        // 给用户登录的密码加密，用于对比
        request.setPassword(securePass(request.getPassword()));
        System.out.println(request.getPassword());
        User user;
        String account = request.getAccount();
        if(account.contains("@")){
            // 通过账号查询用户
            user = userMapper.getByEmail(account);
        }else{
            // 通过账号查询用户
            user = userMapper.getByPhone(account);
        }
        if (user == null) {
            throw new ServiceException("用户名或密码错误");
        }
        // 判断密码是否正确
        if (!user.getPassword().equals(request.getPassword())) {
            System.out.println(request.getPassword());
            throw new ServiceException("用户名或密码错误");
        }
        // 登录成功，封装返回类
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(user, loginDTO);

        return loginDTO;
    }

    @Override
    public LoginDTO register(RegisterRequest registerRequest) {
        registerRequest.setPassword(securePass(registerRequest.getPassword()));
        if(userMapper.getByPhone(registerRequest.getPhone()) != null){
            userMapper.update(registerRequest);
        }else{
            userMapper.save(registerRequest);
        }
        // 登录成功，封装返回类
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(registerRequest, loginDTO);

        return loginDTO;
    }


    @Override
    public boolean findByPhone(String phone) {
        User user = userMapper.getByPhone(phone);
        if (user == null) {
            return false;
        }
        return true;
    }


    private String securePass(String password) {
        return SecureUtil.md5(password + PASS_SALT);
    }
}