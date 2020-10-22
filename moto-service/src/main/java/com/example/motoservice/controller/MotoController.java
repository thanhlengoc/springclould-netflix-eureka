package com.example.motoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MotoController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello from moto-service";
    }

}

