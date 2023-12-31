package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;


import Post_office_system.*;

public class CartController {
	Main m = new Main();
	
	 @FXML
	    private TextField q1;

	    @FXML
	    private TextField q2;
	    
	    @FXML
	    private TextArea t1;

	    @FXML
	    private TextArea t2;
	    
	    
	    private Customer cus;
	
    @FXML
    private Button ibtn;

    @FXML
    private Button pbtn;
    
    public CartController() {
    	
    }
    public void intialize() {
    	
    }
    
    void setCustomer(Customer cus) {
    	this.cus = cus;
    }

    @FXML
    void goToInventory(ActionEvent event) throws IOException {
    	System.out.println("Inventory button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/Inventory.fxml");
    }

    @FXML
    void goToPayment(ActionEvent event)throws IOException {
    	System.out.println("Payment button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/Payment.fxml");
    }

}
