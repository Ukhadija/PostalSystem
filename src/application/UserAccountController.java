package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;


import Post_office_system.*;


public class UserAccountController {
	Main m = new Main();
    @FXML
    private Button Lbtn;

    @FXML
    private Button Cbtn;

    @FXML
    private Button Obtn;

    @FXML
    private Button rbtn;

    @FXML
    private Button Tbtn;
    
    
    private Customer cus;
    
    public UserAccountController() {
    	
    }
    public void intialize() {
    	
    }
    
    void setCustomer(Customer cus) {
    	this.cus = cus;
    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
    	System.out.println("Back link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/Home.fxml");
    }

    @FXML
    void goToRegisterParcel(ActionEvent event) throws IOException {
    	System.out.println("Register Parcel link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeRegister(s, "resources/fxml/RegisterParcel.fxml", cus);
    }

    @FXML
    void goToTrackParcel(ActionEvent event)throws IOException {
    	System.out.println("Track Parcel link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/TrackParcel.fxml");
    }

    @FXML
    void goToInventory(ActionEvent event) throws IOException {
    	System.out.println("Order Supplies link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeInventory(s, "resources/fxml/Inventory.fxml", cus);
    }

    @FXML
    void goToCustomerService(ActionEvent event) throws IOException {
    	System.out.println("Customer Service link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/CustomerService.fxml");
    }

}
