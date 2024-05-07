package dao;
import  dao.IAdoptEvent;
import entity.model.Participants;
import util.DBConnUtil;
import util.DBPropertyUtil;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class AdoptionEvent {
    // Attribute
    private List<IAdoptEvent> participants;
    Participants p;
    // Constructor
    public AdoptionEvent() {
        participants = new ArrayList<>();
    }

    // Method to host the adoption event
    public void hostEvent()
    {

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
            	try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO adoptionevents(EventID, EventName,EventDate,Location,shelter_id) VALUES (?, ?, ?, ?, ?)")) {
            	    // Set parameters for each placeholder
            		Scanner sc= new Scanner(System.in);
            		System.out.println("EventID");
            		int EventID = sc.nextInt();
            		System.out.println("Event Name");
            	    String EventName=sc.next();
            		System.out.println("Event Date");
            	    String EventDate=sc.next();
            		System.out.println("Location");
            		String Location=sc.next();
            		System.out.println("SID");
            		int SID = sc.nextInt();
            	    pstmt.setInt(1, EventID); // petID
            	    pstmt.setString(2, EventName); // name
            	    pstmt.setDate(3,java.sql.Date.valueOf(EventDate) ); // age
            	    pstmt.setString(4,Location); // breed
            	    pstmt.setInt(5, SID); // type
            	   
            	    // Execute the PreparedStatement
            	    int rowsInserted = pstmt.executeUpdate();
            	    if (rowsInserted > 0) {
            	        System.out.println("A new Event has been Hosted.");
            	    } else {
            	        System.out.println("Failed to Host Event");
            	    }
            	}
            	
                catch (SQLException e) {
                    System.out.println("Error: Failed to fetch Event. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    	System.out.println("Event Hosted");
}
    public void registerParticipant()
    {
    	
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
            	try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO participants(participantID, participantName,participantType,EventID) VALUES (?, ?, ?, ?)")) {
            	    // Set parameters for each placeholder
            		Scanner sc= new Scanner(System.in);
            		System.out.println("Participant ID");
            		int participantID = sc.nextInt();
            		System.out.println("Participant  Name");
            	    String participantName=sc.next();
            		System.out.println("Participant Type");
            	    String participantType=sc.next();
            		System.out.println("Event ID");
            		int EventID = sc.nextInt();
            		p=new Participants(participantID,participantName,participantType,EventID);
            	    pstmt.setInt(1,p.getParticipantID()); // petID
            	    pstmt.setString(2, p.getParticipantName()); // name
            	    pstmt.setString(3,p.getParticipantType()); // breed
            	    pstmt.setInt(4, p.getEventID()); // type
            	   
            	    // Execute the PreparedStatement
            	    int rowsInserted = pstmt.executeUpdate();
            	    if (rowsInserted > 0) {
            	        System.out.println("A new participant added");
            	        System.out.println("Participant:"+p.toString());
            	    } else {
            	        System.out.println("Failed to add participant");
            	    }
            	}
            	
                catch (SQLException e) {
                    System.out.println("Error: Failed to fetch Participant. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    	System.out.println("participant added");
}

    // Method to register a participant for the event
    

    public void manageAdoptionEvents() {
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
                        System.out.println("Event ID: " + rs.getInt("eventID") + ", Event Name: " + rs.getString("eventName") + ", Date: " + rs.getDate("eventDate")+",ShelterID:"+rs.getInt("shelter_id"));
                    }
                } catch (SQLException e) {
                    System.out.println("Error: Failed to fetch adoption events. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}