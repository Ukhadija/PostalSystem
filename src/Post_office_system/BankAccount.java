package Post_office_system;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Date;


import java.lang.Math;

public class BankAccount {
	//class variables
	private double balance;
	private String branch;
	private String accountNo;
	private ArrayList<Log> transHistory;
	
	//constructor
	BankAccount(  String branch, String BankName) throws SQLException{
		Random rand = new Random();
		int min =1;
		int max = 1200039;
		String B = "B";
		accountNo = B + String.valueOf((int)(Math.random() * (max - min + 1) + min) );
		min =487347;
		max = 89989888;
		this.balance = Math.random()  * (max - min + 1) + min  ;;
		this.branch = branch;
		this.accountNo = accountNo;
		
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		String query = "Insert into BankAccount "
				+ "	VALUES ('" + accountNo +"'," + balance +",'" + branch+"','" + BankName+  "' );";
		int row = stmt.executeUpdate(query); //execute the insertion
	}
	
	//getter setter
	double getBalance() {
		return this.balance;
	}
	
	String getBranch() {
		return this.branch;
	}
	
	String getAccountNo() {
		return this.accountNo;
	}
	
	//other methods
	boolean makePayment(double amount) {
		if(amount > balance) {
			System.out.println("Insufficient balance to make payment"+amount+" , b = " + balance);
			return false;
		}
		
		System.out.println("Sufficient balance to make payment"+amount+" , b = " + balance);
		
		balance -= amount;
		MySqlHandler sql = new MySqlHandler();
		Connection conn = sql.getCon();
		Statement stmt = sql.getStmt();
		
			try {
				stmt.executeUpdate("Update BankAccount set Balance= " + balance +" where BankAccountNo = '"+ this.accountNo+ "';" );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("tracking information:");
		String data = "Transaction made of amount "+String.valueOf(amount)+" , Remaining Balance is "+String.valueOf(balance);
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		Log t = new Log('T',currentTime,data);
		//transHistory.add(t);
		
		return true;
	}
	
	
	/*void viewTransactionHistory() {
		System.out.println("***TRANSACTION HISTORY***\n");
		for(int i = 0; i < transHistory.size(); i++) {
			transHistory.get(i).printLog();
		}
	}*/
}
