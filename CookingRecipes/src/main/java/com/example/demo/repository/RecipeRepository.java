package com.example.demo.repository;
import com.example.demo.enums.Category;
import com.example.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByNameAndCategoryAndProducts_Name(String name, Category category, String productName);

    List<Recipe> findByNameAndCategory(String name, Category category);

    List<Recipe> findByName(String name);

    List<Recipe> findByCategory(Category category);

    List<Recipe> findByNameAndProducts_Name(String name, String productName);

}
