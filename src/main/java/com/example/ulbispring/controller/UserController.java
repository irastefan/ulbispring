package com.example.ulbispring.controller;

import com.example.ulbispring.entity.UserEntity;
import com.example.ulbispring.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UseRepository useRepo;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            useRepo.save(user);
            return ResponseEntity.ok("User is created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in creating user");
        }
    }

    @GetMapping("/")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Server is started");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
