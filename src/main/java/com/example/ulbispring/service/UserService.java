package com.example.ulbispring.service;

import com.example.ulbispring.entity.UserEntity;
import com.example.ulbispring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ulbispring.exception.UserAlreadyExistsException;
import com.example.ulbispring.exception.UserNotFoundException;
import com.example.ulbispring.repository.UseRepository;

@Service
public class UserService {

    @Autowired
    private UseRepository useRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (useRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("User already exists");
        }
        return useRepo.save(user);
    }

    public User getUserById(Long id) throws UserNotFoundException {
        UserEntity user = useRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return User.toModel(user);
    }
}
