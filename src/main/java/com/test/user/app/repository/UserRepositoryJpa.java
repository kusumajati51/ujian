package com.test.user.app.repository;

import com.test.user.app.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Integer> {
    User findByName(String name);
    User findByEmail(String email);
}
