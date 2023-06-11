package com.example.demo.mapper;

import com.example.demo.dto.CreateRecipeDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RecipeMapper {

    public CreateRecipeDto toDto(Recipe entity) {
        Set<ProductDto> products = entity.getProducts().stream()
                .map(this::toProductDto)
                .collect(Collectors.toSet());

        return CreateRecipeDto.builder()
                .name(entity.getName())
                .products(products)
                .category(entity.getCategory())
                .description(entity.getDescription())
                .rate(entity.getRate())
                .owner(entity.getOwner())
                .build();
    }

    public Recipe toEntity(CreateRecipeDto dto) {
        Set<Product> products = dto.getProducts().stream()
                .map(this::toProductEntity)
                .collect(Collectors.toSet());

        return Recipe.builder()
                .name(dto.getName())
                .products(products)
                .category(dto.getCategory())
                .description(dto.getDescription())
                .rate(dto.getRate())
                .owner(dto.getOwner())
                .build();
    }

    private ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .measure(product.getMeasure())
                .quantity(product.getQuantity())
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
