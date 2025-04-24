package com.example.back.controller;


import com.example.back.common.Result;
import com.example.back.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private ICarService carService;

    @GetMapping("/find")
    public Result findCar(@RequestParam String account){
        return Result.success(carService.findCar(account));
    }
}
