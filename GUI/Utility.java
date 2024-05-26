

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utility 
{
	public String dburl="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
	public String user="aa2005685";
	public String pass="aa2005685";
	
	Statement stmt;
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	CallableStatement cstmt;
	Boolean reslt;

	
	public Utility() throws SQLException 
	{
		conn = DriverManager.getConnection(dburl, user, pass);
		stmt = conn.createStatement();
	}
	
	public void terminate() throws SQLException
	{
		stmt.close();
		conn.close();
	}
}
