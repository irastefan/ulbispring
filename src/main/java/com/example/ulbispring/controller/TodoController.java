package com.example.ulbispring.controller;

import com.example.ulbispring.entity.TodoEntity;
import com.example.ulbispring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService TodoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(TodoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in creating todo");
        }
    }

    @PutMapping
    public ResponseEntity completedTodo(@RequestParam Long todoId) {
        try {
            return ResponseEntity.ok(TodoService.completeTodo(todoId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error in completing todo");
        }
    }
}
