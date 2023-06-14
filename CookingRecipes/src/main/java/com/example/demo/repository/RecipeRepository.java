package com.example.demo.repository;

import com.example.demo.enums.Category;
import com.example.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r JOIN r.products p " +
            "WHERE (:name IS NULL OR LOWER(r.name) LIKE CONCAT('%', LOWER(:name), '%')) " +
            "AND (:category IS NULL OR r.category = :category) " +
            "AND (:query IS NULL OR LOWER(p.name) LIKE CONCAT('%', LOWER(:query), '%'))")
    List<Recipe> searchRecipes(
            @Param("name") String name,
            @Param("category") Category category,
            @Param("query") String query
    );


}