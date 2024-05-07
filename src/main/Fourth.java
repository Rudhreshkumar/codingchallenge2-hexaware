package main;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.DriverManager;
import java.sql.Statement;

import util.DBConnUtil;
import util.DBPropertyUtil;
public class Fourth {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		    String fileName="db.properties";
            String mainConnectionString=DBPropertyUtil.getConnectionString(fileName);
            System.out.println(mainConnectionString);
            
            Class.forName(DBPropertyUtil.getDriver(fileName));
            Connection con=DBConnUtil.getConnection(fileName);
           //Connection con=DriverManager.getConnection(mainConnectionString);
           Statement stmt=con.createStatement();
          // stmt.execute("select * from pets");
          // System.err.println("Deleted");
           //Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM pets");
        		   {
          System.out.println("=== Pet Listings ===");
          while (rs.next()) {
              System.out.println(" Name: " + rs.getString("name") + ", Age: " + rs.getInt("age") + ", Breed: " + rs.getString("breed"));
          }
           con.close();
           
        		   }
	}

}
