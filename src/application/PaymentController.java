package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;

import Post_office_system.*;
public class PaymentController {
	Main m = new Main();
	
	public char before;
	public String trackingID;
	
    @FXML
    private TextField Atxt;

    @FXML
    private RadioButton Ebtn;

    @FXML
    private Button Pbtn;

    @FXML
    private Hyperlink blink;

    @FXML
    private RadioButton Mbtn;

    @FXML
    private RadioButton Sbtn;
    
    public PaymentController() {
    	
    }
    public void intialize() {
    	
    }

    @FXML
    void goToUserAccount(ActionEvent event)throws IOException {
    	System.out.println("Back link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/UserAccount.fxml");
    }

    @FXML
    void makePayment(ActionEvent event) throws IOException {
    	boolean card = Mbtn.isSelected();
    	boolean easy = Ebtn.isSelected();
    	boolean sada = Sbtn.isSelected();
    	
    	String account = Atxt.getText();
    	if((card || easy || sada)&& !account.isEmpty())
    	{
    		//make payment
    		char method = ' ';
    		if(card)
    		{
    			method = 'M';
    		}
    		else if(easy)
    		{
    			method = 'E';
    		}
    		else if(sada)
    		{
    			method = 'S';
    		}
    	//	Customer cus = new Customer();
    	//	cus.makePayment(method, account);
	    	System.out.println("Make Payment btn clicked");
	    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		char test = 'R';
	    	if(before == test) {
	    		System.out.println("Payment  ID: " + trackingID);
	    		m.goToShowTrackingDetails(s, trackingID );
    		}
    		else {
    			m.changeScene(s, "resources/fxml/ThankYou.fxml");
    		}
    		
    	}
    	else {
    		//print enter values
    	}
    	
    }

}
