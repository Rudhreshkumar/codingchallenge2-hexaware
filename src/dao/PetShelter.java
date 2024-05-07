package dao;
import entity.model.Pet;
import util.DBConnUtil;
import util.DBPropertyUtil;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import exception.*;

public class PetShelter {
    // Attribute
    private List<Pet> availablePets;
    Pet p;
    Scanner sc =new Scanner(System.in);
    // Constructor
    public PetShelter() {
    	this.availablePets = new ArrayList<Pet>();
    }

    // Method to add a pet to the list of available pets
    public void addPet() {
        //availablePets.add(pet);
    	
    	try {
        	// Load the JDBC driver and get the connection string
            String fileName = "db.properties";
            String mainConnectionString = null; // Initialize the connection string variable
            try {
                mainConnectionString = DBPropertyUtil.getConnectionString(fileName);
            } catch (Exception e) {
                // Handle the exception gracefully
                System.out.println("Error: Failed to retrieve connection string from properties file. " + e.getMessage());
                return; // Exit the method if unable to retrieve the connection string
            }

            
         // Load the JDBC driver
            try {
                Class.forName(DBPropertyUtil.getDriver(fileName));
            } catch (ClassNotFoundException e) {
                // Handle the exception gracefully
                System.out.println("Error: MySQL JDBC Driver not found. " + e.getMessage());
                return; // Exit the method if JDBC driver not found
            }
            // Connect to the database and load the JDBC driver
            try (Connection conn = DBConnUtil.getConnection(fileName)) {
            	try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO pets(petID, name, age, breed, type, AvailableForAdoption, SID) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            	    // Set parameters for each placeholder
            	
            		System.out.println("id:");
            		int petid = sc.nextInt();
            		System.out.println("name:");
            		String name=sc.next();
            		System.out.println("age:");
            		
            		int age = sc.nextInt();
            		//
            		if(age<=0) {
            			throw new InvalidPetAgeException("InvalidPetAgeException");
            		}
            		else {
            		System.out.println("breed:");
            		String breed=sc.next();

            		System.out.println("type:");
            		String type=sc.next();
            		System.out.println("available for adoption:");
            		int availableforadoption=sc.nextInt();
            		System.out.println("sid:");
            		int sid=sc.nextInt();
            		
            		p=new Pet(name,age,breed);
            		
            	    pstmt.setInt(1, petid); // petID
            	    pstmt.setString(2, name); // name
            	    pstmt.setInt(3, age); // age
            	    pstmt.setString(4, breed); // breed
            	    pstmt.setString(5, type); // type
            	    pstmt.setInt(6, availableforadoption); // AvaliableForAdoption
            	    pstmt.setInt(7, sid); // SID

            	    // Execute the PreparedStatement
            	    int rowsInserted = pstmt.executeUpdate();
            	    if (rowsInserted > 0) {
            	    	availablePets.set(petid,p);
            	        System.out.println("A new row has been inserted."+p.toString());
            	    } else {
            	        System.out.println("Failed to insert a new row.");
            	    }
            	}
            	}
                catch (SQLException e) {
                    System.out.println("Error: Failed to fetch pet listings. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    	System.out.println("pet added");
    }
        
        
    

    // Method to remove a pet from the list of available pets
    public void removePet() {
        //availablePets.remove(pet);
    	try {
        	// Load the JDBC driver and get the connection string
            String fileName = "db.properties";
            String mainConnectionString = null; // Initialize the connection string variable
            try {
                mainConnectionString = DBPropertyUtil.getConnectionString(fileName);
            } catch (Exception e) {
                // Handle the exception gracefully
                System.out.println("Error: Failed to retrieve connection string from properties file. " + e.getMessage());
                return; // Exit the method if unable to retrieve the connection string
            }

            
         // Load the JDBC driver
            try {
                Class.forName(DBPropertyUtil.getDriver(fileName));
            } catch (ClassNotFoundException e) {
                // Handle the exception gracefully
                System.out.println("Error: MySQL JDBC Driver not found. " + e.getMessage());
                return; // Exit the method if JDBC driver not found
            }
            // Connect to the database and load the JDBC driver
            try (Connection conn = DBConnUtil.getConnection(fileName)) {
            	try (PreparedStatement pstmt = conn.prepareStatement("delete  from pets where PetID=?");) {
            	    // Set parameters for each placeholder
            	    
                      pstmt.setInt(1,13);
            	    // Execute the PreparedStatement
            	    int rowsDeleted = pstmt.executeUpdate();
            	    if (rowsDeleted > 0) {
            	        System.out.println("A new row has been deleted.");
            	    } else {
            	        System.out.println("Failed to delete a new row.");
            	    	
            	}}
                catch (SQLException e) {
                    System.out.println("Error: Failed to fetch pet values. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void displayPetListings() {
        try {
        	// Load the JDBC driver and get the connection string
            String fileName = "db.properties";
            String mainConnectionString = null; // Initialize the connection string variable
            try {
                mainConnectionString = DBPropertyUtil.getConnectionString(fileName);
            } catch (Exception e) {
                // Handle the exception gracefully
                System.out.println("Error: Failed to retrieve connection string from properties file. " + e.getMessage());
                return; // Exit the method if unable to retrieve the connection string
            }

            
         // Load the JDBC driver
            try {
                Class.forName(DBPropertyUtil.getDriver(fileName));
            } catch (ClassNotFoundException e) {
                // Handle the exception gracefully
                System.out.println("Error: MySQL JDBC Driver not found. " + e.getMessage());
                return; // Exit the method if JDBC driver not found
            }
            // Connect to the database and load the JDBC driver
            try (Connection conn = DBConnUtil.getConnection(fileName)) {
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT * FROM pets")) {
                    
                    System.out.println("=== Pet Listings ===");
                    while (rs.next()) {
                        System.out.println(" Name: " + rs.getString("name") + ", Age: " + rs.getInt("age") + ", Breed: " + rs.getString("breed"));
                    }
                } catch (SQLException e) {
                    System.out.println("Error: Failed to fetch pet listings. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to list all available pets in the shelter
    public void listAvailablePets() {
        System.out.println("Available Pets:");
       // for (Pet pet : availablePets) {
         //   System.out.println(pet);
      //  }
        try {
        	// Load the JDBC driver and get the connection string
            String fileName = "db.properties";
            String mainConnectionString = null; // Initialize the connection string variable
            try {
                mainConnectionString = DBPropertyUtil.getConnectionString(fileName);
            } catch (Exception e) {
                // Handle the exception gracefully
                System.out.println("Error: Failed to retrieve connection string from properties file. " + e.getMessage());
                return; // Exit the method if unable to retrieve the connection string
            }

            
         // Load the JDBC driver
            try {
                Class.forName(DBPropertyUtil.getDriver(fileName));
            } catch (ClassNotFoundException e) {
                // Handle the exception gracefully
                System.out.println("Error: MySQL JDBC Driver not found. " + e.getMessage());
                return; // Exit the method if JDBC driver not found
            }
            // Connect to the database and load the JDBC driver
            try (Connection conn = DBConnUtil.getConnection(fileName)) {
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT * FROM pets where SID in(select shelterId from Shelters)")) {
                    
                    System.out.println("=== Pet Listings ===");
                    while (rs.next()) {
                        System.out.println(" Name: " + rs.getString("name") + ", Age: " + rs.getInt("age") + ", Breed: " + rs.getString("breed"));
                    }
                } catch (SQLException e) {
                    System.out.println("Error: Failed to fetch pet listings. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}