package enums;

public enum Category {
    SALADS("Салати"),
    STARTERS("Предястия"),
    MEAT_DISHES("Ястия с месо"),
    MEATLESS_DISHES("Ястия без месо"),
    DESSERTS("Десерти");

    private final String categoryName;

    Category(String name) {
        this.categoryName = name;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
