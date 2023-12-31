package Post_office_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public class MySqlHandler {
	private Connection con;
	private Statement stmt;
	public MySqlHandler()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/postoffice","root","Sys123tem");
		this.stmt = con.createStatement(); 
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}

	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
}
