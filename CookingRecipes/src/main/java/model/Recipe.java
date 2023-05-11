package model;

import org.springframework.data.util.Pair;
import enums.Category;
import enums.Quantity;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private int id;
    private String name;

    private Map<String, Pair<Double, Quantity>> products = new HashMap<>();

    private Category category;

    private String description;

    private Double rate;

    private int userId;
}
