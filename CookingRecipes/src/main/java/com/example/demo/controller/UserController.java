package com.example.demo.controller;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.dto.UpdateUserDto;
import com.example.demo.mapper.UserMapper;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
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
                .map(userMapper::toCreateUserDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public User updateUser (@PathVariable Long id, @RequestBody @Valid UpdateUserDto userDto){
        userService.updateUser(id,userMapper.toEntity(userDto));
        return userMapper.toEntity(userDto);
    }

}
