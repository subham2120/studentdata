package com.School.Student.studentdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class health {
    @GetMapping("/health")
    public String healthcheck(){
        return "welcome to my world";
    }
}
