package model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private Set<Recipe> favourites = new HashSet<>();
}
