package model;

import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.List;

public class Recipe {

    private String name;

    private HashMap<String, Pair<Double, Quantity>> products;

    private Category category;

    private String description;

    private List<Double> votes;

    private double rate;

    private int userId;
}
