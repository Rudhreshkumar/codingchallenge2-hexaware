package util;
import exception.*;
import java.io.FileInputStream;
import java.util.Properties;

public class DBPropertyUtil  {
	
	public static String getDriver(String filename) throws Exception {
    	FileInputStream fis=new FileInputStream(filename);
    	Properties props=new Properties();
    	props.load(fis);
    	
    	return props.getProperty("driver");
    }
	
	
	
        public static String getConnectionString(String filename) throws Exception {
        	FileInputStream fis=new FileInputStream(filename);
        	Properties props=new Properties();
        	try{
        		props.load(fis);
        	}
        	catch(Exception e) {
        	    // File not found, throw custom exception
        	    throw new FileHandlingException("File not found: " + e.getMessage());
        	}
        	String connectionString=props.getProperty("protocol")+"//"+props.getProperty("host")+":"+ props.getProperty("port")+"/"+props.getProperty("database")
        	+"?user="+props.getProperty("user")+"&password="+props.getProperty("password");
        	
        	//System.out.println(props);
        	return connectionString;
        }
        
}
