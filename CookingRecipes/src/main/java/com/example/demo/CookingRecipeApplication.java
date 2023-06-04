package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CookingRecipeApplication {

    //public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(CookingRecipeApplication.class);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);
    public static void main(String[] args) {
        SpringApplication.run(CookingRecipeApplication.class, args);
    }

}

