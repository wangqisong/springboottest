package com.example.springboottest.service;

import com.example.springboottest.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Integer id);
}
