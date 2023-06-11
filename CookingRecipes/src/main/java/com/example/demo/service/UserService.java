package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
    }

    public Long createUser(User user) {
        return userRepository.save(user).getId();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User userToEdit = optionalUser.get();
            userToEdit.setEmail(user.getEmail());
            userToEdit.setPassword(user.getPassword());
            userToEdit.setUsername(user.getUsername());
            userToEdit.setFavourites(user.getFavourites());
        } else {
            userRepository.save(user);
        }
        return user;
    }


}
