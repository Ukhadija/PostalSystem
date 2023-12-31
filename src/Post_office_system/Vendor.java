package Post_office_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
public class Vendor {
	//class variables
	private String Name;
	private ArrayList<Item> itemList;
	
	//constructor
	Vendor(String Name, ArrayList<Item> items){
		this.Name = Name;
		this.itemList = items;
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		Log l = new Log('C',currentTime, "Vendor made");
		String query = "Insert into vendors(VendorName)\r\n"
				+ "	VALUES (" + Name + "' );";
		try {
			int row = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //execute the insertion
		
	}
	//getter setters
	String getName() {
		return this.Name;
	}
	
	void setName(String n) {
		this.Name = n;
	}
	
	//other methods
	public void addItem(Item i) {
		this.itemList.add(i);
	}
	
	public void addItem(String ItemNo, String n, String d, int q, double p) {
		Item i = null;
		try {
			i = new Item(ItemNo, n, d, q, p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.itemList.add(i);
	}
	
	public double getEstimate(String ItemNo) throws SQLException
	{
		double price=0;
		MySqlHandler sql = new MySqlHandler();
		Connection conn = sql.getCon();
		Statement stmt = sql.getStmt();
		ResultSet rs = stmt.executeQuery("select price, quantity from Item where ItemNo ='" + ItemNo +"',");
		price = rs.getDouble("price") * rs.getInt("quantity");
		conn.close();
		return price;
	}
	
	double orderItem(ArrayList<Item> it) throws SQLException{
		double amt = 0;
		for( Item Item: it)
		{
			System.out.println("ordered item" + Item.getDesc());
			amt += getEstimate(Item.getItemNo());
		}
		
		return amt;
	}
}
