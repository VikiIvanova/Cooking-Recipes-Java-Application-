package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AppUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private int id;


    private String username;


    private String email;

    private String password;

    @Transient
    private Set<Recipe> recipes = new HashSet<>();

    @Transient
    private Set<Recipe> favourites = new HashSet<>();
}
