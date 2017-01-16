package DB_utls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import selenium_utls.PropertiesReader;

/**
 * The Class SQL.
 */
public class SQL {

	String dbUrl = PropertiesReader.readProperty("dburl");
	String dbUsername = PropertiesReader.readProperty("dbusername");
	String dbPassword = PropertiesReader.readProperty("dbpassword");
	
	static Connection con = null;
	static Statement stmt = null;
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	
	public SQL(String dbtype){
				
		String selectdb = dbtype.toUpperCase();
		switch(selectdb){
		
		case "MYSQL":
			System.out.println("creating mysql connection");
			try {
				Class.forName(PropertiesReader.readProperty("mysqldriver"));
				con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
				stmt = con.createStatement();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "ORACLE":
			System.out.println("creating oracle connection");
			try {
				Class.forName(PropertiesReader.readProperty("oracledriver"));
				con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
				stmt = con.createStatement();
				
			} catch (ClassNotFoundException cnfe) {
				// TODO Auto-generated catch block
				cnfe.printStackTrace();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			break;
			
		case "POSTGRE":
			System.out.println("creating postgre connection");
			try {
				Class.forName(PropertiesReader.readProperty("postgredriver"));
				con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
				stmt = con.createStatement();
			} catch (ClassNotFoundException cnfe) {
				// TODO Auto-generated catch block
				cnfe.printStackTrace();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			break;
		default:
			System.out.println("Connection available only for "
					+ " MYSQL "
					+ " ORACLE "
					+ " POSTGRE");
		}
		
	}
	
	/**
	 * Execute query.
	 *
	 * @param query the query
	 */
	public void executeQuery(String query){
		
		System.out.println(query);
		try {
			
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
	}
	
}
