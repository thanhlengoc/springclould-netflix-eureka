package com.example.carservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CarController {

    @GetMapping("/car-greeting")
    public String greeting() {
        return "Hello from car-service";
    }
}
