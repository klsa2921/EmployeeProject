package com.example.employeespring.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth/demoController")
public class DemoController {
    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeController(){
        return ResponseEntity.ok("Controller successful...");
    }
}