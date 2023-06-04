package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Long createUser(User user) {
        return userRepository.save(user).getId();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
