package com.example.back.mapper;

import com.example.back.dao.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper {
    Car getByPhone(String phone);
}
