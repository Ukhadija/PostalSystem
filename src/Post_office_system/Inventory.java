package Post_office_system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class Inventory {
	//class variables
	static int Pid = 0; //static variable to calculate customer ID
	int InventoryID;
	private int capacity;
	private ArrayList<Item> itemList;
	private ArrayList<Item> Cart;
	private ArrayList<Vendor> vendors;
	
	//constructor
	Inventory(int c, ArrayList<Vendor> v, ArrayList<Item> i) throws SQLException{
		this.capacity = c;
		this.itemList = i;
		this.vendors = v;
		
		Pid++;
		InventoryID = Pid;
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		String query = "Insert into Inventory "
				+ "	VALUES ("+Pid+"," + capacity + " );";
		//int row = stmt.executeUpdate(query); //execute the insertion
	}
	
	//getter setter
	int getCapacity() {
		return this.capacity;
	}
	
	
	//other methods
	void enterNewItem(String itemCode, String itemName,String desc, int quantity, double price) {
		Item item= null;
		try {
			item = new Item(itemCode, itemName, desc, quantity, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		itemList.add(item);
	}
	
	void enterNewVendor(String Name, ArrayList<Item> i) {
		Vendor v = new Vendor(Name, i);
		vendors.add(v);
	}
	
	String searchItem(String code) {
		
		
		MySqlHandler sql = new MySqlHandler();
		Connection conn = sql.getCon();
		Statement stmt = sql.getStmt();
		ResultSet rs;
		try {
			rs = stmt.executeQuery("select * from Item where ItemNo ='" + code +"';");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDouble(5));
				String desc = rs.getString(1)+ " "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDouble(5);
				return desc;
				
			}
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		for(Item it: itemList)
		{
			String itemCode = it.getItemNo();
			if(itemCode == code)
			{
				return it.getDesc();
			}
		}
		*/
		
		return null;
	}
	
	void useItem(String code,int quantity) {
		

		MySqlHandler sql = new MySqlHandler();
		Connection conn = sql.getCon();
		Statement stmt = sql.getStmt();
		ResultSet rs;
		try {
			
			stmt.executeUpdate("Update Item Set  Quantity =" + quantity +" where ItemNo ='"+ code+"';");
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Item it: itemList)
		{
			String itemCode = it.getItemNo();
			if(itemCode == code)
			{
				it.updateItem(quantity);
				
			}
		}
	}
	
	void restockItems(ArrayList<Item> items) throws SQLException {
		//Vendor vendor = new Vendor();
		double amt = 0;
		for(Vendor vendor: vendors)
		{
			amt += vendor.orderItem(items);
		}
		System.out.println("monthly spending updated by: Rs."+ amt);
	}
	
	void viewInventory() {
		MySqlHandler sql = new MySqlHandler();
		Connection conn = sql.getCon();
		Statement stmt = sql.getStmt();
		ResultSet rs ;
		try {
			rs = stmt.executeQuery("select * from Item");
			System.out.println("**********************************\n");
			System.out.println("Item Number: %s\nName: %s\nDescription: %s\nQuantity: %d\n");
			System.out.println("**********************************\n");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDouble(5));
				
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	boolean verifyItem(String itemNum) {
		for(int i = 0; i < itemList.size(); i++) {
			if(this.itemList.get(i).getItemNo() == itemNum) {
				return true;
			}
		}
		
		return false;
	}
	
	boolean checkQuantity(String itemNo, int quantity) {
		for(int i = 0; i < itemList.size(); i++) {
			if(this.itemList.get(i).getItemNo() == itemNo) {
				int q = this.itemList.get(i).getQuantity();
				if( q >= quantity) {
					return true;
				}
			}
		}
		return false;
	}
	
	Item getItem(String itemNo) {
		for(int i = 0; i < itemList.size(); i++) {
			if(this.itemList.get(i).getItemNo() == itemNo) {
				return this.itemList.get(i);
			}
		}
		
		return null;
	}
	
	boolean addToCart(String itemNo, int quantity) {
		if(verifyItem(itemNo) && checkQuantity(itemNo, quantity)) {
			this.useItem(itemNo, quantity);//saves in database
			Item i = this.getItem(itemNo);
			i.setQuantity(quantity);
			Cart.add(i);
			return true;
		}
		
		return false;
	}
	
	double getTotalAmount() {
		double total = 0;
		for(int i = 0; i < Cart.size(); i++) {
			double price = Cart.get(i).getPrice();
			price *= Cart.get(i).getQuantity();
			total+=price;
		}
		
		return total;
	}
	
	
	/*void checkOut() {
		return this.getTotalAmount();
	}*/
}
