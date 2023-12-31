package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import Post_office_system.*;

public class InventoryController {
	 Main m = new Main();
	 
	   @FXML
	    private TextArea t1;

	    @FXML
	    private TextArea t2;
	    
	    @FXML
	    private TextArea t3;
	    
	    @FXML
	    private TextArea t4;

	    @FXML
	    private TextArea t5;
	    
	    @FXML
	    private TextArea t6;
	    
	    
	    private Customer cus;
	    
	    
    @FXML
    private Button abtn2;

    @FXML
    private Button abtn1;

    @FXML
    private Button cbtn;

    @FXML
    private Button abtn4;

    @FXML
    private Button abtn3;

    @FXML
    private Button abtn6;

    @FXML
    private Button abtn5;
    
    public InventoryController() {
    	int num =0 ;
		MySqlHandler sql = new MySqlHandler();
		Connection conn = sql.getCon();
		Statement stmt = sql.getStmt();
		ResultSet rs, rs1;
		try {
			
			rs = stmt.executeQuery("Select * from Item");
			while(rs.next() && num <6)
			{
				String itemName = rs.getString("itemName");
				String itemDesc = rs.getString(2);
				double itemPrice = rs.getDouble(4);
				num++;
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void intialize() {
    	
    }
    
    void setCustomer(Customer cus ) {
    	this.cus = cus;
    }

    @FXML
    void goToCart(ActionEvent event) throws IOException{
    	System.out.println("Cart link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeCart(s, "resources/fxml/Cart.fxml", cus);
    }
    
    @FXML
    void goToUserAccount(ActionEvent event) throws IOException{
    	System.out.println("Cart link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/UserAccount.fxml");
    }

    @FXML
    void addToCart(ActionEvent event) throws IOException {
    	System.out.println("Item Added");
    	
    	//
    }


}
