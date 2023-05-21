package com.example.demo.dto;

import com.example.demo.enums.Category;
import com.example.demo.enums.Quantity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private Long id;
    private String name;
    private Map<String, Pair<Double, Quantity>> products = new HashMap<>();
    private Category category;
    private String description;
    private Double rate;
    private int userId;
}
