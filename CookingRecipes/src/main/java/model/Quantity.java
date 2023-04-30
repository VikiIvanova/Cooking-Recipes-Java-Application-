package model;

public enum Quantity {
    GRAM("гр"),
    MILLILITRES("мл"),
    COUNT("бр");

    private final String quantityName;

    Quantity(String name) {
        this.quantityName = name;

    }

    public String getQuantityName(){
        return quantityName;
    }
}
