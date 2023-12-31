package com.example.ulbispring.controller;

import com.example.ulbispring.entity.UserEntity;
import com.example.ulbispring.exception.UserAlreadyExistsException;
import com.example.ulbispring.exception.UserNotFoundException;
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
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't create user");
        }
    }

    @GetMapping("/")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't find any user");
        }
    }

    @GetMapping
    public ResponseEntity getUserById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't find this user");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUserById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Couldn't delete this user");
        }
    }
}
