package Post_office_system;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Item {
	//class variables
	private String ItemNo;
	private String Name;
	private String Desc;
	private int quantity;
	private double price;
	
	//constructor
	Item(String ItemNo, String Name, String Desc, int quantity, double price) throws SQLException{
		this.ItemNo = ItemNo;
		this.setName(Name);
		this.setDesc(Desc);
		this.setQuantity(quantity);
		this.setPrice(price);
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		Log l = new Log('I',currentTime, "Item made");
		//execute query
		String query = "Insert into Item(ItemNo, ItemName, ItemDesc, Quantity,price)\r\n"
				
				+ "	VALUES ('"+ ItemNo  +"','" + Name +"','" + Desc+"'," + quantity +"," 
				+price+ " );";
		int row = stmt.executeUpdate(query); //execute the insertion
	}
	
	//getter setters
	
	public String getItemNo() {
		return ItemNo;
	}

	public void setItemNo(String no) {
		ItemNo = no;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//other methods
	void updateItem(String name, String Desc, int q, double p){
		
		
		this.setName(name);
		this.setDesc(Desc);
		this.setQuantity(q);
		this.setPrice(p);
		
	}
	
	void updateItem(int q){
		this.setQuantity(q);
		
	}
	
	boolean verifyID(String ID) {
		if(ID == this.ItemNo) 
			return true;
		return false;
	}

	
}
