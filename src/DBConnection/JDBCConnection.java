/**
 * 
 */
package DBConnection;

/**
 * @author PC
 *
 */

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Logger;
import java.util.logging.Level;


public class JDBCConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String username = "root";
		String password = "ASNmjc54";
		String url 	    = "jdbc:mysql://localhost:3306/petscaredb";
		
		Connection connection;
		Statement statement;
		ResultSet rs; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException ex){
			Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, "MySQL JDBC Driver not found", ex);
		}
		
		
		try {
		
			connection = DriverManager.getConnection(url, username, password);
			statement  = connection.createStatement();
			//statement.executeUpdate("INSERT INTO Rol (id_rol, nombre_rol) VALUES (5, 'Administrativo2')");
			rs = statement.executeQuery("SELECT * FROM Rol");
			
			rs.next();
			do {
				System.out.println(rs.getInt("id_rol") + ":" + rs.getString("nombre_rol"));
			}while(rs.next());
			
		} catch (SQLException ex) {
			Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

}
