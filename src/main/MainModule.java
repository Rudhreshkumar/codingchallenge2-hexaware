package main;
import java.sql.*;
import dao.*;
import dao.CashDonation;
import entity.model.*;
import util.DBConnUtil;
import util.DBPropertyUtil;
import java.util.Scanner;
import dao.IAdoptEventImpl;
public class MainModule {
    private static final String DB_URL = "jdbc:mysql://localhost:3308/petpals";
    private static final String DB_USER = "root";
   private static final String DB_PASSWORD = "";
   
    private Scanner scanner;
    PetShelter ps=new PetShelter();
    
    CashDonation cd=new CashDonation();
    AdoptionEvent ac=new AdoptionEvent();
    public MainModule() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("===== Pet Adoption Platform Menu =====");
        System.out.println("1. Display Pet Listings");
        System.out.println("2. Record Cash Donation");
        System.out.println("3. Manage Adoption Events");
        System.out.println("4. Display Avaliable Pets");
        System.out.println("5. Add Pets");
        System.out.println("6. Remove Pets");
        System.out.println("7. host event");
        System.out.println("8. register participant");
        System.out.println("9. exit");
        System.out.println("=======================================");
        System.out.print("Enter your choice: ");
    }
    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ps.displayPetListings();
                    break;
                case 2:
                    cd.recordDonation();
                    break;
                case 3:
                    ac.manageAdoptionEvents();
                    break;
                case 4:
                	
                	ps.listAvailablePets();
                    
                    break;
                case 5:
                	
                	ps.addPet();
       
                	break;
               case 6:
                	
                	ps.removePet();
       
                	break;
               case 7:
            	   	ac.hostEvent();
            	   	break;
               case 8:
            	   //ac.registerParticipant();
            	   
            	   IAdoptEventImpl refe=new IAdoptEventImpl();
            	   Scanner sc= new Scanner(System.in);
           		System.out.println("Participant ID");
           		int participantID = sc.nextInt();
           		System.out.println("Participant  Name");
           	    String participantName=sc.next();
           		System.out.println("Participant Type");
           	    String participantType=sc.next();
           		System.out.println("Event ID");
           		int EventID = sc.nextInt();
           		
           		Participants participant=new Participants(participantID,participantName,participantType,EventID);
           		//new Participants(22,"tt","ADOPTER",1,1);
           		refe.registerParticipant(participant);
                  // ae.registerParticipant();
            	   
                case 9:
                	System.out.println("Exiting...");
       
                	break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }


    
    
    
    
    
    
    


    
    
    
    
    
    
    
    
    
    /*public void recordCashDonation() {
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
                try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO donation(DonationID, DonorName, DonationAmount) VALUES (?, ?, ?)")) {
                    // Prompt user for donor information and donation amount
                    System.out.print("Enter donor id: ");
                    int DonationID = scanner.nextInt();
                    System.out.print("Enter donor name: ");
                    String donorName = scanner.next();
                    System.out.print("Enter donation amount: ");
                    double Amount = scanner.nextDouble();

                    // Set parameters and execute the query
                    pstmt.setInt(1, DonationID);
                    pstmt.setString(2, donorName);
                    pstmt.setDouble(3, Amount);
                    int rowsInserted = pstmt.executeUpdate();

                    // Check if the donation was recorded successfully
                    if (rowsInserted > 0) {
                        System.out.println("Cash donation recorded successfully.");
                    } else {
                        System.out.println("Failed to record cash donation.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to record cash donation. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }*/

    
    
    
    
    
    
    
    
    
    
   

   

    
   /* public void manageAdoptionEvents() {
        try {
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
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT * FROM AdoptionEvents")) {
                    
                    System.out.println("=== Adoption Events ===");
                    while (rs.next()) {
                        System.out.println("Event ID: " + rs.getInt("eventID") + ", Event Name: " + rs.getString("eventName") + ", Date: " + rs.getDate("eventDate")+",ShelterID:"+rs.getInt("SID"));
                    }
                } catch (SQLException e) {
                    System.out.println("Error: Failed to fetch adoption events. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MySQL JDBC Driver not found.");
        }
    }*/
    
//    public void manageAdoptionEvents() {
//        try {
//            String fileName = "db.properties";
//            String mainConnectionString = null; // Initialize the connection string variable
//            try {
//                mainConnectionString = DBPropertyUtil.getConnectionString(fileName);
//            } catch (Exception e) {
//                // Handle the exception gracefully
//                System.out.println("Error: Failed to retrieve connection string from properties file. " + e.getMessage());
//                return; // Exit the method if unable to retrieve the connection string
//            }
//
//            // Load the JDBC driver
//            try {
//                Class.forName(DBPropertyUtil.getDriver(fileName));
//            } catch (ClassNotFoundException e) {
//                // Handle the exception gracefully
//                System.out.println("Error: MySQL JDBC Driver not found. " + e.getMessage());
//                return; // Exit the method if JDBC driver not found
//            }
//
//            // Connect to the database
//            try (Connection conn = DBConnUtil.getConnection(fileName)) {
//                try (Statement stmt = conn.createStatement();
//                     ResultSet rs = stmt.executeQuery("SELECT * FROM AdoptionEvents")) {
//                    
//                    System.out.println("=== Adoption Events ===");
//                    while (rs.next()) {
//                        System.out.println("Event ID: " + rs.getInt("eventID") + ", Event Name: " + rs.getString("eventName") + ", Date: " + rs.getDate("eventDate")+",ShelterID:"+rs.getInt("SID"));
//                    }
//                } catch (SQLException e) {
//                    System.out.println("Error: Failed to fetch adoption events. " + e.getMessage());
//                }
//            } catch (SQLException e) {
//                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//



    // Other methods remain unchanged...

    public static void main(String[] args) {
    	
        MainModule mainModule = new MainModule();
        mainModule.run();
        /*PetShelter ps=new PetShelter();
         Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the name of the pet:");
        String name = scanner.nextLine();
        
        System.out.println("Enter the age of the pet:");
        int age = scanner.nextInt();
        
        System.out.println("Enter the breed of the pet:");
        String breed = scanner.next();
        
        Pet p = new Pet(name, age, breed);
        
      
        
        ps.addPet(p);*/
    }
}
