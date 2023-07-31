package com.example.ulbispring.repository;

import com.example.ulbispring.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UseRepository extends CrudRepository<UserEntity, Long> {
}
