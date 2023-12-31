package Post_office_system;

import java.sql.SQLException;
import java.sql.Statement;

public class ParcelDescription {
	
	//class variables
	private String TrackingID;
	private String TrackingInfo; // list of track info
	private int priority;
	private double weight;
	private String mailingAdd;
	private String destAdd;
	private String receiverName;
	private String contact;
	private double price;
	
	
	//constructor
	public ParcelDescription(String ID, int p, double w, String m, String d, String n, String c)
	{
		this.TrackingID = ID;
		TrackingInfo = "1)Parcel Registered\n";
		setPriority(p);
		setWeight(w);
		this.mailingAdd = m;
		this.destAdd = d;
		this.receiverName = n;
		this.contact = c;
		this.price = this.weight * 20;
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		
		//execute query
		String query = "Insert into ParcelDescription\r\n"
				+ "	VALUES ('" + TrackingID +"','" + TrackingInfo +"'," + p+"," + w+",'" 
				+m+"','" + d+"','"+ n+"','"+ c + "',"+ price+ " );";
		try {
			int row = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //execute the insertion
		
	}
	
	
	//getter setters
	public double getPrice() {
		return this.price;
	}
	
	public String getTrackingID() {
		return this.TrackingID;
	}
	
	public String getTrackingInfo() {
		return TrackingInfo;
	}
	
	public void setTrackingInfo(String trackingInfo) {
		TrackingInfo += "->" + trackingInfo + "\n";
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getMailingAdd() {
		return this.mailingAdd;
	}
	
	public void setMailingAdd(String address) {
		this.mailingAdd = address;
	}
	
	public String getDestAdd() {
		return this.destAdd;
	}
	
	public void setDestAdd(String address) {
		this.destAdd = address;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
		this.price = this.weight*20;
	}
	
	public String getName() {
		return this.receiverName;
	}
	
	public void setName(String name) {
		this.receiverName = name;
	}
	
	public String getContact() {
		return this.contact;
	}
	
	public void setContact(String c) {
		this.contact = c;
	}
	
	//other methods
	public void updateStatus(String status)
	{
		System.out.println("status updated");
	}
	
	public void addDetails(String update)
	{
		TrackingInfo += "->" + update + "\n";
		System.out.println("details updated");
	}
	
	public Boolean checkID(String trackNum)
	{
		if(trackNum == TrackingInfo)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void changeDestAdd(String addy)
	{
		this.setDestAdd(addy);
		
	}
	
	public String getDetails()
	{
		String detail;
		detail = "Track Info: "+ TrackingInfo + "\n Priority: " + priority + "\n Weight: " + weight + "\n Mailing address: "+ mailingAdd + "\n Destination address: "+ destAdd + "\n Reciever Name: "+ this.receiverName + "\n Contact Info: "+ this.contact ;
		
		return detail;
	}
	
	public void addDetails(String Track, int p, double w, String madd, String dadd, String name, String c)
	{
		setTrackingInfo(Track);
		setPriority(p);
		setWeight(w);
		setMailingAdd(madd);
		setDestAdd(dadd);
		setName(name);
		setContact(c);
		
	}
	
}
