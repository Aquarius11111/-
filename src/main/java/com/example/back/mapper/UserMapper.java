package com.example.back.mapper;

import com.example.back.controller.request.RegisterRequest;
import com.example.back.dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getByPhone(String phone);

    User getByEmail(String email);

    void save(RegisterRequest registerRequest);

    void update(RegisterRequest registerRequest);
}
