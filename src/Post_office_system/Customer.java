package Post_office_system;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Customer extends User{
	//class variables
	static int Pid = 0; //static variable to calculate customer ID
	private String customerID;
	private BankAccount account;
	private ArrayList<Parcel> parcel;
	private Inventory inventory;
	
	//constructor
	public Customer ()
	{
		
	}
	Customer(String name, String address, String phone, String email,
			String cnic, String Username, String pass, BankAccount Bacc, Inventory i) throws SQLException{
		super(name, address, phone, email,cnic, Username, pass); //user added to database
		parcel = new ArrayList<Parcel>();
		String P = "C";
		System.out.println("in id:"+i.InventoryID);
		P = P + String.valueOf(Pid);
		Pid++;
		this.setAccount(Bacc);// bank acc
		this.setCustomerID(P);
		this.setInventory(i);	
		//add to database
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		Log l = new Log('C',currentTime, "Customer made");
		String query = "Insert into Customer (Username, BankAccID, InventoryID) "
				+ "	VALUES ('" + Username +"','" + Bacc.getAccountNo() +"'," + getInventory().InventoryID+ " );";
		
		System.out.println("Insert into Customer "
				+ "	VALUES ('" + P +"','" + Username +"','" + Bacc.getAccountNo() +"'," + getInventory().InventoryID+ " );");
		stmt.executeUpdate(query); //execute the insertion
		
	}
	
	//getter setters
	String getCustomerID() {
		return this.customerID;
	}
	
	//other methods
	public String registerParcel(int priority, String mailingAdd, String destAdd, double size, String name, String contact) {
		Parcel p = new Parcel(priority, size, mailingAdd, destAdd , name, contact); //autp saved in db
		String trackingID;
		char method = 'M';
		double amount = p.getAmount();
		System.out.println("amount:"+amount);
		boolean ack = this.makePayment(method, this.account.getAccountNo());
		if(ack) {
			//parcel.add(p);
			trackingID = p.getTrackingID();
			System.out.println("Parcel Registered"+ trackingID);
			return trackingID;
		}
		
		p = null;
		System.out.println("Parcel not Registered! TRY AGAIN!");
		return null;
	}
	
	void CustomerService(CustomerService custService)
	{
		custService.connect();
		String CustomerMessage , EmployeeMessage = "How can we help you?";
		String reply;
		do {
			CustomerMessage = MessageFromRep(EmployeeMessage);
			EmployeeMessage = custService.messageFromCustomer(CustomerMessage);
			
			System.out.println("Exit? E");
			Scanner scan = new Scanner(System.in);
			reply = scan.next();
			scan.close();
		}while(reply != "E");
	}
	
	String MessageFromRep(String msg)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("message received: " + msg);
		System.out.println("send reply");
		String reply = scan.next();
		
		scan.close();
		return reply;
	}
	
	public String trackParcel(String ID) { //use db to track parcel
		String more  = "Y";
			
			MySqlHandler sql = new MySqlHandler();
			Connection conn = sql.getCon();
			Statement stmt = sql.getStmt();
			try {
				ResultSet rs =  stmt.executeQuery("Select * from parcel right join ParcelDescription "
						+ "on parcel.ParcelDescription = ParcelDescription.TrackingID where TrackingID = '" 
						+ID+ "' ;");
				rs.next();
				System.out.println("tracking information:");
				
				System.out.println(rs.getString(1)+ " "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "
				+rs.getInt(5)+" "+rs.getDouble(6)+rs.getString(7)+" "+rs.getString(8)+" "
						+rs.getString(9)+" "+rs.getString(10)+" "+rs.getDouble(11)+" ");
				String result = rs.getString(4);
				conn.close();
				
				return result;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
			
	}
	
	void orderSupply(){
		Scanner s = new Scanner(System.in);
		getInventory().viewInventory();
		
		boolean endSale = false;
		
		
		String itemNum;
		int q;
		while (!endSale) {
			System.out.println("Enter Item Number: ");
			itemNum = s.nextLine();
			
			System.out.println("Enter Item Quantity: ");
			q = s.nextInt();
			getInventory().addToCart(itemNum, q);
			
			System.out.println("Enter 'y' to continue and 'x' to end sale.");
			char cont = s.next().charAt(0);
			if(cont == 'x') {
				endSale = true;
			}
		}
		
		s.close();
		double amount = getInventory().getTotalAmount();
		this.makePayment('M',this.account.getAccountNo());
		
		//allocate parcel
	}	
		
	public boolean makePayment(char method, String AccNo) {
		
		boolean pay = false;
		double amount = 1;
			System.out.println("Using Mastercard");
			boolean ack = getAccount().makePayment(amount);
			
			if(ack) {
				System.out.println("Payment Successful\n");
				pay = true;
			}
			else {
				System.out.println("Payment not Successful\n");
			}
		
		
	//	getAccount().viewTransactionHistory(); 
		return pay;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	@Override
	void trackParcel(String ID, String updates) {
		// TODO Auto-generated method stub
		
	}
	@Override
	void trackParcel() {
		// TODO Auto-generated method stub
		
	}
	
	
	//void giveFeedback() {
	//}
	//void redirectMail(){		
	//}
}
