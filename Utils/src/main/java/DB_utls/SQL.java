package DB_utls;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import selenium_utls.PropertiesReader;

/**
 * The Class SQL.
 */
public class SQL {

	static String dbUrl = PropertiesReader.readProperty("dburl");
	static String dbUsername = PropertiesReader.readProperty("dbusername");
	static String dbPassword = PropertiesReader.readProperty("dbpassword");
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	
	static {
				
		String selectdb = PropertiesReader.readProperty("dbtype").toUpperCase();
		switch(selectdb){
		
		case "MYSQL":
			System.out.println("creating mysql connection");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
				
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
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
				
				
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
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
				
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
	 * @param val the val
	 */
public ResultSet selectQuery(String query, Object [] val){
		
		System.out.println();
		ResultSet rs = null;
		try {
			//String query = "select * from ACD where ACD_ID < ?";
			pstmt = con.prepareStatement(query);
			for(int i=0;i<val.length;i++)
			{
				if(val[i] instanceof Integer)
				{
					pstmt.setInt(i+1, (int) val[i]);
					
				} else if(val[i] instanceof String)	{
					
					pstmt.setString(i+1, (String) val[i]);
					
				} else if(val[i] instanceof Long ){
					
					pstmt.setLong(i+1, (Long) val[i]);
					
				} else if(val[i] instanceof Double) {
					
					pstmt.setDouble(i+1, (Double) val[i]);
					
				} else if(val[i] instanceof Float) {
					
					pstmt.setDouble(i+1, (Float) val[i]);
					
				} else if(val[i] instanceof Date) {
					
					pstmt.setDate(i+1, (Date) val[i]);
					
				} else if(val[i] instanceof Time) {
					
					pstmt.setTime(i+1, (Time) val[i]);
					
				} else if(val[i] instanceof Timestamp) {
					
					pstmt.setTimestamp(i+1, (Timestamp) val[i]);
					
				}
					
			}
			
			rs=pstmt.executeQuery();  
			
		} catch (SQLException e) {
		
			System.out.println(e);
		}
		
		return rs;	
	}
	
}
