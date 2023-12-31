package Post_office_system;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Bank {
	private String bankName;
	private ArrayList<BankAccount> accounts;
	
	Bank(String name){
		bankName = name;
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		String query = "Insert into Bank(BankName) "
				+ "	VALUES ('" + bankName + "' );";
		//try {
		//	int row = stmt.executeUpdate(query);
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//} //execute the insertion
	}
	
	public String getName() {
		return this.bankName;
	}
	
	public void addAccount(BankAccount a) {
		accounts.add(a);
		//add account to database table
	}
	
	//void makeTransaction() {}
}
