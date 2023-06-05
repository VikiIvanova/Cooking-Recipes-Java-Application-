package com.example.demo.dto;

import com.example.demo.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    private String username;
    private String password;
    @Email(message = "Invalid email address!")
    private String email;
    private Set<Recipe> favourites = new HashSet<>();
}