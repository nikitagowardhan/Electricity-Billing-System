package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EbsDao {
	
	private String url = "jdbc:mysql://localhost:3306/ebs";
	private String uname = "root";
	private String upass = "abc123";
	private String driver = "com.mysql.jdbc.Driver";

	public Connection getConnect() throws ClassNotFoundException, SQLException
    {
    	Class.forName(driver);
		Connection c = DriverManager.getConnection(url, uname, upass);
		
		return c;
    }
	


}


