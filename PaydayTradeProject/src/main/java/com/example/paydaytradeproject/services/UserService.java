package com.example.paydaytradeproject.services;

import com.example.paydaytradeproject.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getUser();
    User registerUser(User user);
}
