package com.example.demo.services;

import com.example.demo.models.User;

public interface UserService {
    User registerUser(User user);
    User updateUser(User user);
}
