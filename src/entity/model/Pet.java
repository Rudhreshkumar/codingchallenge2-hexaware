package entity.model;
public class Pet {
	    // Attributes
	    private String name;
	    private int age;
	    private String breed;

	    // Constructor
	    public Pet(String name, int age, String breed) {
	        this.name = name;
	        this.age = age;
	        this.breed = breed;
	    }
	    // Getters
	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String getBreed() {
	        return breed;
	    }

	    // Setters
	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public void setBreed(String breed) {
	        this.breed = breed;
	    }

	    // ToString method
	    public String toString() {
	        return "Name: " + name + ", Age: " + age + ", Breed: " + breed;
	    }

	    // Example usage
	   /* public static void main(String[] args) {
	        // Creating a pet object
	        Pet myPet = new Pet("Max", 3, "Labrador");
	        // Getting attributes
	        System.out.println("Name: " + myPet.getName());
	        System.out.println("Age: " + myPet.getAge());
	        System.out.println("Breed: " + myPet.getBreed());

	        // Setting attributes
	        myPet.setAge(4);
	        myPet.setBreed("Golden Retriever");

	        // Printing pet details using ToString() method
	        System.out.println(myPet);
	    }*/
	}

