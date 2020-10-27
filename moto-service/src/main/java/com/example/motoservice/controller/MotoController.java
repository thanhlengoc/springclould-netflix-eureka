package com.example.motoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/moto")
public class MotoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello from moto-service";
    }

    @GetMapping("/greeting/{serviceName}")
    public String getGreetingFromCar(@PathVariable String serviceName) {
        final String domain = this.discoveryClient.getInstances(serviceName).get(0).getUri().toString();
        final String uri = domain + "/api/car-greeting";
        System.out.println("uri: " + uri);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

}

