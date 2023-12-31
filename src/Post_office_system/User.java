package Post_office_system;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class User {
	private String Name;
	private String Address;
	private String Phone;
	private String email;
	private String CNIC;
	private Account acc; 
	
	
	public User()
	{
		
	}
	
	public User(User user)
	{
		this.Name = user.Name;
		this.Address = user.Address;
		this.Phone = user.Phone;
		this.email = user.email;
		this.CNIC = user.CNIC;
		this.setAcc(user.getAcc());
	}
	
	public User(String name, String address, String phone, String email, String cnic, String Username, String pass) throws SQLException
	{
		setName(name);
		setAddress(address);
		setPhone(phone);
		setEmail(email);
		setCNIC(cnic); 
		setAcc(new Account(Username, pass));
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		String query = "Insert into User_(FullName, Address, Phone, Email,CNIC, Username, Pass)\r\n"
				+ "	VALUES ('" + name +"','" + address +"','" + phone+"','" + email+"','" 
				+CNIC+"','" + Username+"','"+pass+ "' );";
		System.out.println(query);
		int row = stmt.executeUpdate(query); //execute the insertion
	}
	
	public User(String name, String address, String phone, String email, String cnic, Account a)
	{
		setName(name);
		setAddress(address);
		setPhone(phone);
		setEmail(email);
		setCNIC(cnic);
		setAcc(new Account (getAcc()));
		
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCNIC() {
		return CNIC;
	}
	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}
	
	void createAccount(Account acc)
	{
		this.setAcc(new Account(acc));
	}
	void deleteAccount()
	{
		this.setAcc(null);
	}
	abstract void trackParcel();
	abstract void trackParcel(String ID, String updates);
	String trackParcel(String ID)
	{
		return "";
	}
	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}
	
	
	
}
