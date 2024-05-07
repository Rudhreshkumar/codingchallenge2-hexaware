package entity.model;

public class Cat extends Pet {
    // Additional attribute
    private String catColor;

    // Constructor
    public Cat(String name, int age, String breed, String catColor) {
        super(name, age, breed);
        this.catColor = catColor;
    }

    // Getter for CatColor
    public String getCatColor() {
        return catColor;
    }

    // Setter for CatColor
    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }
}