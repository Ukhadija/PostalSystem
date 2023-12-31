package Post_office_system;

public class Account {
	private String Username;
	private String Password;
	Account ()
	{
		
	}
	Account(String usr, String pass)
	{
		Username = usr;
		Password = pass;
	}
	Account (Account acc)
	{
		this.Username = acc.Username;
		this.Password = acc.Password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
	public void setPassword(String pass)
	{
		Password = pass;
	}
	
	
	
	public  void Login()
	{
		
	}
	
	public boolean changePassword(String currPass, String newPass)
	{
		if(currPass == Password)
		{
			Password = newPass;
			return true;
		}
		else {
			return false;
		}
	}
}
