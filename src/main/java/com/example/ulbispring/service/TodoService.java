package com.example.ulbispring.service;

import com.example.ulbispring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ulbispring.entity.TodoEntity;
import com.example.ulbispring.entity.UserEntity;
import com.example.ulbispring.repository.TodoRepository;
import com.example.ulbispring.repository.UserRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepo;
    @Autowired
    private UserRepository userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long todoId) {
        TodoEntity todo = todoRepo.findById(todoId).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
