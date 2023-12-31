package Post_office_system;
import java.sql.SQLException;
import java.util.*;

public class Postman extends User {
	private String PostmanId;
	private List<Parcel>  parcels ;
	//Account acc;
	
	public Postman(String Id,String name,String address,String phone,String email,String cnic,String User, String Pass, List<Parcel> parcel) throws SQLException
	{
		super(name, address, phone, email, cnic,User, Pass);
		this.PostmanId = Id;
		this.parcels = parcel;
	}
	
	public String getPostmanId() {
		return PostmanId;
	}

	public void setPostmanId(String postmanId) {
		PostmanId = postmanId;
	}

	public List<Parcel> getParcels() {
		return parcels;
	}

	public void setParcels(List<Parcel> parcels) {
		this.parcels = parcels;
	}
	
	
	void addParcel(Parcel parcel) {
		parcels.add(parcel);
	}
	
	void updateStatus()
	{
		
	}



	@Override
	void trackParcel() {
		try (// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter tracking ID to update");
			//Scan.nextint()
			String ID = scan.next();
			for(Parcel p :parcels )
			{
				String PID = p.getParcelId();
				if(PID  == ID)
				{
					System.out.println("Enter updates");
					String updates = scan.next();
					p.updateTrackingInfo(updates);
				}
			}
		}
	
	}

	@Override
	void trackParcel(String ID, String updates) {
		// TODO Auto-generated method stub
		
	}

	
}
