package Post_office_system;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDateTime;  


public class PostOfficeEmployee extends User {
	static int Pid = 0; //static variable to calculate Parcel ID
	private String EmployeeID;
	private List<Parcel>  parcels ;
	Inventory inventory;
	
	public PostOfficeEmployee( String name, String address, String phone,
			String email, String cnic, String user, String pass, List<Parcel> parcel, Inventory in) throws SQLException {
		super(name, address, phone, email, cnic, user, pass);
		String P = "E";
		P = P + String.valueOf(Pid);
		Pid++;
		setEmployeeID(P);
		parcels = parcel;
		inventory = in;
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		//execute query
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		Log l = new Log('C',currentTime, "PostOfficeEmployee made");
		String query = "Insert into PostOfficeEmployee\r\n"
				+ "	VALUES (" + getEmployeeID() +",'" + user +"','" + in.InventoryID + "' );";
		try {
			int row = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //execute the insertion
		// TODO Auto-generated constructor stub
	}

	
	
	/*public void registerMail()
	{
		
	}
	
	public void manageInventory()
	{
		
	}
	
	public void validateAddress()
	{
		
	}*/

	public PostOfficeEmployee() {
		// TODO Auto-generated constructor stub
	}



	public void manageInventory() throws SQLException
	{
		//enter new items
		/*String end ="N";
		Scanner scan = new Scanner(System.in);
		String input;
		int choice;
		ArrayList<Item> items = new ArrayList<Item>();
		Item item;
		String i, n, desc;
		double p; int q;
		do
		{
			System.out.println("press 1) enter item\n 2) restock inventory 3) view inventory 4) exit");
			choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				do {
					item = null;
					System.out.println("Enter new itemNumber:\n");
					i = scan.next();
					System.out.println("Enter item name: ");
					n =scan.next();
					System.out.println("Enter item quantity: ");
					q =scan.nextInt();
					System.out.println("Enter item price: ");
					p =scan.nextDouble();
					System.out.println("Enter item desc: ");
					desc =scan.next();
					inventory.enterNewItem(i, n, desc, q, p);
					System.out.println("enter more items? press Y else N");
					end = scan.next();
				}while(end != "N");
				break;
			case 2:
				do {
					System.out.println("Restock items");
					inventory.viewInventory();
					System.out.println("Enter item Number to restock: ");
					i =scan.next();
					System.out.println("Enter item quantity: ");
					q =scan.nextInt();
					Item it = inventory.getItem(i);
					it.setQuantity(q);
					items.add(it);
					System.out.println("enter more items? press Y else N");
					end = scan.next();
					}while(end != "N");
				inventory.restockItems(items);
				break;
			case 3:
				inventory.viewInventory();
				break;
			case 4:
				break;
			default:
				System.out.println("wrong choice");
			}
		}while(choice != 4);
	}
	public List<Parcel> getParcels() {
		return parcels;
		*/
		MySqlHandler sql = new MySqlHandler();
		Connection conn = sql.getCon();
		Statement stmt = sql.getStmt();
		try {
			ResultSet rs = stmt.executeQuery("Select * from Item");
			
			while(rs.next())
			{
				int quantity = rs.getInt("Quantity");
				if(quantity == 0)
				{
					//restock 
					quantity += 10;
					stmt.executeUpdate("Update Item set Quantity=" +quantity+" where ItemNo = '"+rs.getString("ItemNo")+"';");
				}
			}
			System.out.println("Restocked");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void setParcels(List<Parcel> parcels) {
		this.parcels = parcels;
	}


	@Override
	public void trackParcel(String ID, String updates) {// update tracking information
		// TODO Auto-generated method stub
			//query for updating the parcel
			MySqlHandler sql = new MySqlHandler();
			Connection conn = sql.getCon();
			Statement stmt = sql.getStmt();
			try {
				String query = "select * from parcelDescription natural join parcel where trackingID = '" + ID +"';";

				ResultSet rs1 = stmt.executeQuery(query);
				rs1.next();
				System.out.println(rs1.getString(2));
				updates = rs1.getString(2) + updates;
				
				stmt.executeUpdate("Update parcelDescription Set TrackingInfo ='" + updates +"' where TrackingID ='"+ID+"';");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	}



	public String getEmployeeID() {
		return EmployeeID;
	}



	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}



	@Override
	void trackParcel() {
		// TODO Auto-generated method stub
		
	}
}
