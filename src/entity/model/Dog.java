package entity.model;

public class Dog extends Pet
{
    // Additional attribute
    private String dogBreed;

    // Constructor
    public Dog(String name, int age, String breed, String dogBreed) {
        super(name, age, breed);
        this.dogBreed = dogBreed;
    }

    // Getter for DogBreed
    public String getDogBreed() {
        return dogBreed;
    }

    // Setter for DogBreed
    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }
}
