package entity;

import exception.InvalidPetAgeException;

public class Dog extends Pet {
    private String dogBreed;

    public Dog(String name, int age, String breed) throws InvalidPetAgeException {
        super(name, age, breed);
        this.dogBreed = breed;
    }

    public String getDogBreed() { return dogBreed; }
    public void setDogBreed(String dogBreed) { this.dogBreed = dogBreed; }

    @Override
    public String toString() {
        return super.toString() + ", DogBreed=" + dogBreed;
    }
}
