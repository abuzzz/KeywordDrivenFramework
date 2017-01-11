package DB_utls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import selenium_utls.PropertiesReader;

/**
 * The Class SQL.
 */
public class SQL {

	static final String DB_URL = PropertiesReader.readProperty("dburl");
	static final String JDBC_DRIVER = PropertiesReader.readProperty("dbdriver");
	static final String DB_USERNAME = PropertiesReader.readProperty("dbusername");
	static final String DB_PASSWORD = PropertiesReader.readProperty("dbpassword");
	
	static Connection con = null;
	static Statement stmt = null;
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public static void getConnection(){
		
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL);
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stmt = con.createStatement();	 
	}
	
	/**
	 * Execute query.
	 *
	 * @param query the query
	 */
	public static void executeQuery(String query){
		
		try {
			
			stmt.executeQuery(query);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	

	
}
