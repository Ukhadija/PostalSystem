package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;
import java.sql.SQLException;

import Post_office_system.*;


public class LoginController {
	Main m = new Main();

    @FXML
    private Hyperlink emplink;

    @FXML
    private Button Lbtn;

    @FXML
    private PasswordField ptxt;

    @FXML
    private Hyperlink blink;

    @FXML
    private TextField utxt;
    
    public LoginController() {
    	
    }
    public void intialize() {
    	
    }
    
    void goToUserAccount(Stage s, Customer cus)throws IOException {
    	m.changeScenewithParameter(s, "resources/fxml/UserAccount.fxml", cus);
    }
    

    @FXML
    void Login(ActionEvent event)throws IOException, SQLException {
    	System.out.println("Login button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	
    	String username = utxt.getText();
    	String password = ptxt.getText();
    	if(username.isEmpty()|| password.isEmpty()) {
    		System.out.println ("enter values");
    	}
    	else {
    		Post_Office po = new Post_Office();
    		Customer cus =  po.LoginCustomer(username, password);
    		if( cus == null)
    		{
    			System.out.println("Wrong username or account");
    		}
    		else {
    			this.goToUserAccount(s, cus);
    		}
    	}
    }

    @FXML
    void goToLoginEmployee(ActionEvent event)throws IOException {
    	System.out.println("Hyperlink clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/LoginEmployee.fxml");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	System.out.println("Back link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/Home.fxml");
    }

}
