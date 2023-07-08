package com.example.TaskPP312.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TaskPP312.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}