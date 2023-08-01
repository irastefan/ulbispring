package com.example.ulbispring.controller;

import com.example.ulbispring.entity.UserEntity;
import com.example.ulbispring.exception.UserAlreadyExists;
import com.example.ulbispring.repository.UseRepository;
import com.example.ulbispring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User is created");
        } catch (UserAlreadyExists e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in creating user");
        }
    }

    @GetMapping("/")
    public ResponseEntity getUsers() {
        try {
            //return ResponseEntity.ok(useRepo.findAll());
            return ResponseEntity.ok("Users");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
