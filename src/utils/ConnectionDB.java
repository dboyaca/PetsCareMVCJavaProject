package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.*;
import org.json.simple.parser.*;


public class ConnectionDB {

    
    public static Connection getConnection() {
	//public static void main(String[] args) {
    	JSONParser parser = new JSONParser();
    	Connection conn = null;
    	
		try{
			String credentials_path;
			credentials_path = System.getProperty("user.dir") + "/src/utils/credentialsDB.json";
			JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));
	        String host     = (String)jsonObject.get("db_ip");
	        String port     = (String)jsonObject.get("db_port");
	        String username = (String)jsonObject.get("db_user");
	        String password = (String)jsonObject.get("db_password");
	        String dbURL = "jdbc:mysql://"+host+":"+port+"/petscaredb";
	        conn = DriverManager.getConnection(dbURL, username, password);
	        
	        //if (conn != null) {
	        //	System.out.println("Conectado");
	        //}
		}
	    catch( SQLException | FileNotFoundException ex ) {
	        ex.printStackTrace();
	    } 
	    catch (IOException ex) {
	        ex.printStackTrace();
	    } catch (Exception ex) {
	        Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
	    }
		
		return conn;
    }
}