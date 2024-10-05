package entity;

import exception.InvalidPetAgeException;

public class Cat extends Pet {
    private String catColor;

    public Cat(String name, int age, String breed, String catColor) throws InvalidPetAgeException {
        super(name, age, breed);
        this.catColor = catColor;
    }

    public String getCatColor() { return catColor; }
    public void setCatColor(String catColor) { this.catColor = catColor; }

    @Override
    public String toString() {
        return super.toString() + ", CatColor=" + catColor;
    }
}
