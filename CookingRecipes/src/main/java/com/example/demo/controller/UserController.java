package com.example.demo.controller;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.dto.LoginUserDto;
import com.example.demo.dto.UpdateUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(14);
        String hashedPassword = encoder.encode(userDto.getPassword());
        userDto.setPassword(hashedPassword);
        return userService.createUser(userMapper.toEntity(userDto));
    }

    @GetMapping("/allusers")
    public List<CreateUserDto> getAllUsers() {
        final List<User> usersList = userService.getAllUsers();

        return usersList.stream()
                .map(userMapper::toCreateUserDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public UserDto getUserByID(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return userMapper.toUserDto(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserDto userDto) {
        userService.updateUser(id, userMapper.toEntity(userDto));
        return userMapper.toEntity(userDto);
    }

    @PostMapping("/login")
    public Long login(@Valid @RequestBody LoginUserDto loginUserDto) {
        Long toReturnId = -1L;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(14);
        User user = userService.findUserByEmail(loginUserDto.getEmail());
        if (encoder.matches(loginUserDto.getPassword(), user.getPassword())) {
            toReturnId = user.getId();
        }
        return toReturnId;
    }

    @GetMapping("/getId")
    public Long getUserId(@RequestParam String username) {
        return userService.getUserId(username);
    }
}
