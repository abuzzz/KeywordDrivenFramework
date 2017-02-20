package test_sql_qu;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import DB_utls.SQL;

public class testsql {
	
	@Test
	public  void sqltest() throws SQLException {
		ResultSet rs = SQL.selectQuery("select * from dual");
		while (rs.next())
			System.out.println(rs.getString(1));
	}

	@Test
	public  void sqltest2() throws SQLException {
		ResultSet rs = SQL.selectQuery("select * from dual");
		while (rs.next())
			System.out.println(rs.getString(1));
	}
	
}
