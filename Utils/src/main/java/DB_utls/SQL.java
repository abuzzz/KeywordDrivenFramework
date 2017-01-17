package DB_utls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import selenium_utls.PropertiesReader;

/**
 * The Class SQL.
 */
public class SQL {

	String dbUrl = PropertiesReader.readProperty("dburl");
	String dbUsername = PropertiesReader.readProperty("dbusername");
	String dbPassword = PropertiesReader.readProperty("dbpassword");
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	
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
public void selectQuery(String query, Object [] val){
		
		System.out.println();
		try {
			//String query = "select * from ACD where ACD_ID < ?";
			pstmt = con.prepareStatement(query);
			for(int i=0;i<val.length;i++)
			{
				if(val[i] instanceof Integer)
				{
					pstmt.setInt(i+1, (int) val[i]);
				}
				if(val[i] instanceof String)
				{
					pstmt.setString(i+1, (String) val[i]);
				}
					
			}
			//pstmt.setString(2, "ACD1");
			ResultSet rs=pstmt.executeQuery();  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		} catch (SQLException e) {
		
			System.out.println(e);
		}
			
	}
	
}
