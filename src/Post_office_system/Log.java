package Post_office_system;
import java.time.LocalDateTime;  
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Log {
	private static int Pid = 0; //static variable to calculate Parcel ID
	private char ID;
	private String date;
	private String status;
	
	Log(char id, String date, String status){
		this.setID(id);
		this.setDate(date);
		this.setStatus(status);
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		String query = "Insert into logs_ (LogType, Date_, Status_) "
				+ "	VALUES ( '"+ id +"','" + date +"','" + status + "' );";
		try {
			int row = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //execute the insertion
	}
	
	void printLog(){
		System.out.println("Log ID: "+getID()+ " , " );
		System.out.println("Date: "+getDate()+ " , " );
		System.out.println("Data: %s \n"+getStatus() );
	}

	public char getID() {
		return ID;
	}

	public void setID(char iD) {
		ID = iD;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date2) {
		this.date = date2;
	}



}
