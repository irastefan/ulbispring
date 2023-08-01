package com.example.ulbispring.service;

import com.example.ulbispring.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ulbispring.exception.UserAlreadyExists;
import com.example.ulbispring.repository.UseRepository;

@Service
public class UserService {

    @Autowired
    private UseRepository useRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExists {
        if (useRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExists("User already exists");
        }
        return useRepo.save(user);
    }
}
