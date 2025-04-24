package com.example.back.service.impl;

import com.example.back.dao.Car;
import com.example.back.dao.User;
import com.example.back.exception.ServiceException;
import com.example.back.mapper.CarMapper;
import com.example.back.mapper.UserMapper;
import com.example.back.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {
    @Autowired
    private CarMapper carMapper;

    @Autowired
    private UserMapper userMapper;


    public boolean findByPhone(String phone) {
        Car car = carMapper.getByPhone(phone);
        if (car == null) {
            return false;
        }
        return true;
    }

    public boolean findByEmail(String email) {
        User user = userMapper.getByEmail(email);

        return findByPhone(user.getPhone());
    }


    @Override
    public boolean findCar(String account) {
        if(account.contains("@")){
            // 通过email查询用户
            return findByEmail(account);
        }else{
            // 通过手机号查询用户
            return findByPhone(account);
        }
    }
}