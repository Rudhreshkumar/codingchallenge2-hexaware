package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import dao.Donation;
import util.DBConnUtil;
import util.DBPropertyUtil;

import exception.*;

public class CashDonation extends Donation {
    // Additional attribute
    private LocalDateTime donationDate;
     Scanner scanner= new Scanner(System.in);
      //default cons
     public CashDonation() {
    	 System.out.println("default cons");
     }
    // Constructor
    public CashDonation(String donorName, double amount, LocalDateTime donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    // Method to record a cash donation
    @Override
    public void recordDonation() {
        // Implement record keeping logic here
        /*System.out.println("Cash donation recorded for donor: " + getDonorName() +
                ", Amount: $" + getAmount() + ", Date: " + donationDate);*/
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

            // Connect to the database
            try (Connection conn = DBConnUtil.getConnection(fileName)) {
                // Prepare the statement
                try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO donations(DonationID, DonorName, DonationType , DonationAmount,DonationDate,donatedto) VALUES (?,?, ?,?, ?,?)")) {
                    // Prompt user for donor information and donation amount
                    System.out.print("Enter donor id: ");
                    int DonationID = scanner.nextInt();
                    System.out.print("Enter donor name: ");
                    String donorName = scanner.next();
                    
                    System.out.print("Enter donation amount: ");
                    
                    double Amount = scanner.nextDouble();
                    System.out.print("to which shelter you want to donate : enter its id");
                    int donatedto = scanner.nextInt();
                    if(Amount<=0) {
                    	throw new InsufficientFundsException("InsufficientFundsException");
                    }
                    else {
                    // Set parameters and execute the query
                    	
                    pstmt.setInt(1, DonationID);
                    pstmt.setString(2, donorName);
                    pstmt.setString(3,"Cash");
                    pstmt.setDouble(4, Amount);
                    pstmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
                    pstmt.setInt(6, donatedto);
                    int rowsInserted = pstmt.executeUpdate();

                    // Check if the donation was recorded successfully
                    if (rowsInserted > 0) {
                        System.out.println("Cash donation recorded successfully.");
                    } else {
                        System.out.println("Failed to record cash donation.");
                    }
                    } 
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to record cash donation. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Example usage
   /* public static void main(String[] args) {
        // Creating a cash donation object
        CashDonation cashDonation = new CashDonation("John Doe", 100.50, LocalDateTime.now());

        // Recording the donation
        cashDonation.recordDonation();
    }*/
}
