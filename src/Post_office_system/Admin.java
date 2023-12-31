package Post_office_system;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Admin extends User{
	private String AdminID;
	static int Pid = 0; //static variable to calculate Parcel ID
	private ArrayList<Log> logs;
	//private ArrayList<Report> reports;

	
	Admin(String name,String address,String phone,String email,String cnic,String User, String Pass, ArrayList<Log> l) throws SQLException{
		super(name,address,phone, email, cnic,User,Pass);
		String P = "A";
		P = P + String.valueOf(Pid);
		Pid++;
		AdminID = P;
		logs = l;
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		String query = "Insert into Admin_\r\n"
				+ "	VALUES (" + AdminID +",'" + User + "' );";
		try {
			int row = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //execute the insertion
		
	}
	
	String getAdminID() {
		return this.AdminID;
	}
	
	void addLog(Log l) {
		logs.add(l);
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		String query = "Insert into logs_(LogType, Date_, Status_)"
				+ "	VALUES ('" + l.getID() +"','" + l.getDate() +"','" + l.getStatus()+ "' );";
		try {
			int row = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //execute the insertion
	}
	
	ArrayList<Log> requestLog() {
		System.out.println("request granted");
		for(Log log: logs)
		{
			log.printLog();
		}
		
		return logs;
	}

	@Override
	void trackParcel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void trackParcel(String ID, String updates) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*void getLogs() {
	
	}
	
	void generateReports() {
		
	}
	
	void editUser() {
		
		
	}*/
}
