package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Recipe> recipes = new HashSet<>();

   // @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    //@JoinTable(name = "favourite_recipes",
    //        joinColumns = @JoinColumn(name = "user_id" ),
    //        inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    @OneToMany(mappedBy = "recipeId")
    private Set<FavouriteRecipe> favourites = new HashSet<>();
}
