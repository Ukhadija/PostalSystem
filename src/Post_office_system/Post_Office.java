package Post_office_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Post_Office {
	private ArrayList<Parcel>  parcels ;
	private ArrayList<Customer>  Customers ;
	private ArrayList<PostOfficeEmployee>  employees ;
	private Inventory inventory;
	private ArrayList<Vendor>  Vendors ;
	private ArrayList<Item>  items ;
	private List<Log> logs ;
	private ArrayList<Bank> banks;
	
	public Post_Office() throws SQLException
	{
		parcels = new ArrayList<Parcel>();
		Customers = new ArrayList<Customer>();
		employees =  new ArrayList<PostOfficeEmployee>();
		Vendors = new ArrayList<Vendor>();
		items= new ArrayList<Item>();
		int capacity = 5000;
		inventory = new Inventory(capacity, Vendors, items);
		banks = new ArrayList<Bank>();
		initializeBanks();
		
	}
	public void initializeBanks()
	{
		Bank Faysal = new Bank("Faysal");
		Bank Habib = new Bank("Habib");
		Bank EasyPaisa = new Bank("EasyPaisa");
	}
	
	public Customer LoginCustomer(String Username, String Password)
	{
		System.out.println(Username+" "+ Password);
		MySqlHandler sql = new MySqlHandler();
		Connection conn = sql.getCon();
		Statement stmt = sql.getStmt();
		ResultSet rs, rs1;
		try {
			
			rs = stmt.executeQuery("Select * from User_");
			while(rs.next())
			{
				System.out.println("try");
				System.out.println(rs.getString(7)+" "+ rs.getString(8));
				String User = rs.getString(7);
				String Pass = rs.getString(8);
				if(User.equals(Username) && Pass.equals(Password))
				{
					System.out.println("here");
					rs1 = stmt.executeQuery("select * from User_ natural join Customer;");
					rs1.next();
					Customer c = new Customer();
					c.setCustomerID(rs1.getString(9));
					c.setName(rs1.getString(3));
					c.setAddress(rs1.getString(4));
					c.setCNIC(rs1.getString(7));
					c.setEmail(rs1.getString(6));
					c.setInventory(inventory);
					c.setPhone(rs1.getString(5));
					Account B = new Account();
					B.setPassword(Password);
					B.setUsername(Username);
					//for bank acc
					
					c.setAcc(B);
					rs1 = stmt.executeQuery("select * from bankAccount natural join Customer");
					rs1.next();
					String BankAccno = rs1.getString(1);
					String branch = rs1.getString(3);
					String bankn = rs1.getString(4);
					BankAccount bAcc = new BankAccount(branch, bankn);
					c.setAccount(bAcc);
					
					return c;
				}
			}
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("here null");
		return null;
	}
	
	public void InventoryController(PostOfficeEmployee POE) throws SQLException
	{
		POE.manageInventory();
	}
	
	public PostOfficeEmployee LoginEmployee(String Username, String Password)
	{
		
		MySqlHandler sql = new MySqlHandler();
		Connection conn = sql.getCon();
		Statement stmt = sql.getStmt();
		ResultSet rs, rs1;
		try {
			
			rs = stmt.executeQuery("Select * from User_");
			while(rs.next())
			{
				String User = rs.getString(7);
				String Pass = rs.getString(8);
				if(User.equals( Username) && Pass.equals(Password))
				{
					
					rs1 = stmt.executeQuery("select * from user_ natural join PostOfficeEmployee");
					rs1.next();
					PostOfficeEmployee c = new PostOfficeEmployee();
					c.setEmployeeID(rs1.getString(9));
					c.setName(rs1.getString(3));
					c.setAddress(rs1.getString(4));
					c.setCNIC(rs1.getString(7));
					c.setEmail(rs1.getString(6));
					c.inventory = inventory;
					c.setPhone(rs1.getString(5));
					Account B = new Account();
					B.setPassword(Password);
					B.setUsername(Username);
					//for bank acc
					c.setAcc(B);
					c.setParcels(this.parcels);
					return c;
				}
			}
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void setName(String string) {
		// TODO Auto-generated method stub
		
	}
	public void CreateAccount(String name, String address, String email, String phone,
			String cnic, String user, String pass ) throws SQLException
	{
		
		Account acc =  new Account(user, pass);
		
		BankAccount Bacc = new BankAccount("Rawalpindi", "Faysal");
		Customer Customer = new Customer(name, address,phone, email ,cnic,user, pass,Bacc,inventory);
		
	}
	
	void TrackParcel(PostOfficeEmployee p)
	{
	}
	
	public String TrackParcel(String trackID)
	{
		Customer c = new Customer();
    	String details = c.trackParcel(trackID);
    	return details;
	}
	
	
	
	
	public ArrayList<Parcel> getParcels() {
		return parcels;
	}
	public void setParcels(ArrayList<Parcel> parcels) {
		this.parcels = parcels;
	}
	public ArrayList<Customer> getAccounts() {
		return Customers;
	}
	public void setAccounts(ArrayList<Customer> accounts) {
		this.Customers = accounts;
	}
	public ArrayList<PostOfficeEmployee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<PostOfficeEmployee> employees) {
		this.employees = employees;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public ArrayList<Vendor> getVendor() {
		return Vendors;
	}
	public void setVendor(ArrayList<Vendor> vendor) {
		Vendors = vendor;
	}
	public List<Log> getLogs() {
		return logs;
	}
	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}
	
	
}
