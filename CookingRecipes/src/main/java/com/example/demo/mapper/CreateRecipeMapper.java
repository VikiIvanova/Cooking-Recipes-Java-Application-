package com.example.demo.mapper;

import com.example.demo.dto.CreateRecipeDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CreateRecipeMapper {

    public Recipe toEntity(CreateRecipeDto dto, User user) {
        Set<Product> products = dto.getProducts().stream()
                .map(this::toProductEntity)
                .collect(Collectors.toSet());

        return Recipe.builder()
                .name(dto.getName())
                .products(products)
                .category(dto.getCategory())
                .description(dto.getDescription())
                .imagePath("src/main/resources/savedImages/" + dto.getImagePath())
                .rate(dto.getRate())
                .owner(user)
                .build();
    }

    private Product toProductEntity(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .measure(productDto.getMeasure())
                .quantity(productDto.getQuantity())
                .build();
    }


}
