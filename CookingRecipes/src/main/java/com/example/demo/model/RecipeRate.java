package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "recipe_rate")
@Table(uniqueConstraints = @UniqueConstraint(name = "UniqueRecipeAndUser", columnNames = {"app_user", "recipe"}))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "app_user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe")
    private Recipe recipe;

    @Column(name = "rate")
    private Double rate;
}
