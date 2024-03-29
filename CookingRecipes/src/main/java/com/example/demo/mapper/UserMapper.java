package com.example.demo.mapper;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.dto.UpdateUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public CreateUserDto toCreateUserDto(User entity) {
        return CreateUserDto.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    public User toEntity(CreateUserDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
    }

    public User toEntity(UpdateUserDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .favourites(dto.getFavourites())
                .build();
    }
}
