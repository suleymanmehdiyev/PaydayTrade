package com.example.paydaytradeproject.services.impls;

import com.example.paydaytradeproject.models.User;
import com.example.paydaytradeproject.repository.UserRepository;
import com.example.paydaytradeproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(User user) {
        userRepository.save(user);
        return user;
    }
}
