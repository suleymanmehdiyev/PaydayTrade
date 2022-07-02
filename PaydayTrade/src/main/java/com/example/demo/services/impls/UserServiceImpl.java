package com.example.demo.services.impls;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.utils.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    MailSender mailSender = new MailSender();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User registerUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepository.getUserById(user.getId());
        if(user.getName() != null){
            user1.setName(user.getName());
        }
        if(user.getEmail() != null){
            user1.setEmail(user.getEmail());
        }
        if(user.getPassword() != null){
            user1.setPassword(user.getPassword());
        }
        userRepository.save(user1);
        return user1;
    }
}
