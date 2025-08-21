package com.orkhangasanov.controller;

import com.orkhangasanov.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String name) {
        try {
            customerService.registerCustomer(name);
            return ResponseEntity.ok("User registered successfully: " + name);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }

    // Alternative with JSON request body
    @PostMapping("/register/json")
    public ResponseEntity<String> registerUserJson(@RequestBody UserRegistrationRequest request) {
        try {
            customerService.registerCustomer(request.getName());
            return ResponseEntity.ok("User registered successfully: " + request.getName());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }

    // Request DTO
    public static class UserRegistrationRequest {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
