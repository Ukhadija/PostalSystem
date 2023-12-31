package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;

import Post_office_system.*;
import java.lang.*;

public class RegisterParcelController {
	Main m = new Main();
    @FXML
    private TextField mtxt;

    @FXML
    private TextField dtxt;

    @FXML
    private Button Hbtn;

    @FXML
    private CheckBox ucheck;

    @FXML
    private TextField rctxt;

    @FXML
    private TextField wtxt;

    @FXML
    private TextField rntxt;

    @FXML
    private Button rbtn;
    
    private Customer cus;
    
    public RegisterParcelController() {
    	
    }
    public void intialize() {
    	
    }
    
    void setCustomer ( Customer cus) {
    	this.cus = cus;
    }

    @FXML
    void goToUserAccount(ActionEvent event) throws IOException{
    	System.out.println("Back link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/UserAccount.fxml");
    }

    @FXML
    void goToPayment(ActionEvent event) throws IOException {
    	System.out.println("Back link clicked");
    	
    	String weight = wtxt.getText(); 
    	String madd = mtxt.getText();
    	String dadd = dtxt.getText();
    	String name = rntxt.getText();
    	String phone = rctxt.getText();
    	
    	boolean urgent = ucheck.isSelected();
    	
    	String trackingID = ""; //get trackingID
    	double w = Double.parseDouble(weight);
    	if(weight.isEmpty()|| madd.isEmpty() || dadd.isEmpty()|| name.isEmpty() || phone.isEmpty()) {
    		System.out.println ("enter values");
    	}
    	else {
    		//here
    		int priority = (int)Math.random();
 
    		trackingID = cus.registerParcel(priority, madd, dadd, w, name, phone);
    		
	    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    	System.out.println("Parcel registered");
	    	System.out.println(trackingID);
	    	m.goToPayment(s, 'R', trackingID);
	    	
	    }
    }

}
