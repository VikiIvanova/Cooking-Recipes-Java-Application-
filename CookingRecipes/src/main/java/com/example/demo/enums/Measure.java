package com.example.demo.enums;

public enum Measure {
    GRAM("гр"),
    MILLILITRES("мл"),
    COUNT("бр");

    private final String measureName;

    Measure(String name) {
        this.measureName = name;
    }

    public String getMeasureName(){
        return measureName;
    }
}
