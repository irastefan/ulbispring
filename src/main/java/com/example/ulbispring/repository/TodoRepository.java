package com.example.ulbispring.repository;

import com.example.ulbispring.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
