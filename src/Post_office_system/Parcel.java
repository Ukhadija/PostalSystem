package Post_office_system;


import java.lang.Math;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class Parcel {
	
	//class variables
	String ParcelID;
	private String parcelId;
	private ParcelDescription parcelDesc;
	
	//constructors
	public Parcel(int pr, double w, String m, String d, String n, String c)
	{
		int min =1;
		int max = 1200039;
		String P = "P";
		ParcelID = P + String.valueOf((int)(Math.random() * (max - min + 1) + min ));
		String Tid = "T";
		int num = (int)(Math.random() * (max - min + 1) + min );
		Tid += String.valueOf(num);
		System.out.println("PID: "+ParcelID +"TID: "+ Tid);
		parcelId = P;
		parcelDesc = new ParcelDescription(Tid, pr, w, m, d, n, c);
		
		MySqlHandler sql = new MySqlHandler();
		Statement stmt = sql.getStmt();
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		Log l = new Log('P',currentTime, "Parcel made");
		//execute query
		String query = "Insert into Parcel\r\n"
				+ "	VALUES ('" + ParcelID +"','" + Tid +"' );";
		try {
			int row = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //execute the insertion
	}
	
	public Parcel( ParcelDescription pr)
	{
		
		String P = "P";
		P = P + String.valueOf((int) Math.random());
		
		parcelDesc = pr;
		parcelId = P;
	}
	
	
	//getter setters
	public String getParcelId() {
		return parcelId;
	}
	
	public String getTrackingID() {
		System.out.println("Tracking ID from ParcelDesc"+this.parcelDesc.getTrackingID());
		return this.parcelDesc.getTrackingID();
	}

	public double getAmount() {
		return this.parcelDesc.getPrice();
	}
	
	public ParcelDescription getParcelDesc() {
		return parcelDesc;
	}

	public void setParcelDesc(ParcelDescription parcelDesc) {
		this.parcelDesc = parcelDesc;
	}
	
	//other methods
	public void updateStatus(String status)
	{
		parcelDesc.updateStatus(status);
	}

	public String trackParcel(String TrackID)
	{
		String abc  = parcelDesc.getDetails();
		return abc;
	}
	
	public void updateTrackingInfo(String update)
	{
		parcelDesc.addDetails(update);
	}
	
	//public void registerMail()
	//{
	//}
	
}

