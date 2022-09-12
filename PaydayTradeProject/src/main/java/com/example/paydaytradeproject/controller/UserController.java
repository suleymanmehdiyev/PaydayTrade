package com.example.paydaytradeproject.controller;

import com.example.paydaytradeproject.models.User;
import com.example.paydaytradeproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userService.getUser();
        return ResponseEntity.ok(userList);
    }
    @PostMapping("/register")
    ResponseEntity<User> registerUser(@RequestBody User user){
        User userList= userService.registerUser(user);
        return ResponseEntity.ok(userList);
    }
}
