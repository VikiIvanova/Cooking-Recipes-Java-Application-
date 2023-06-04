package com.example.demo.controller;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.mapper.UserMapper;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/createuser")
    public Long createUser(@RequestBody CreateUserDto userDto) {
        return userService.createUser(userMapper.toEntity(userDto));
    }

    @GetMapping("/allusers")
    public List<CreateUserDto> getAllUsers() {
        final List<User> usersList = userService.getAllUsers();

        return usersList.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
