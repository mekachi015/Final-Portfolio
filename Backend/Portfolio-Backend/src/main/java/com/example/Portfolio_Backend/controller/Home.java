package com.example.Portfolio_Backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Home {

    @GetMapping("/")
    public String home() {
        return "Backend is running!";
    }
    
}
