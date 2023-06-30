package com.example.demo.dto;

import com.example.demo.enums.Measure;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private Measure measure;
    private Double quantity;
}
