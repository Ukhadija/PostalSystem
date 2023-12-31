package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;
import java.sql.SQLException;

import Post_office_system.*;
import Post_office_system.Post_Office;

public class LoginEmployeeController {
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

    
    public LoginEmployeeController() {
    	
    }
    public void intialize() {
    	
    }
    
    void goToEmpAccount(Stage s)throws IOException {
    	m.changeScene(s, "resources/fxml/EmployeeAccount.fxml");
    }
    
    @FXML
    void Login(ActionEvent event)throws IOException {
    	System.out.println("Login button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	
    	String username = utxt.getText();
    	String password = ptxt.getText();
    	if(username.isEmpty()|| password.isEmpty()) {
    		System.out.println ("enter values");
    	}
    	else {
    		Post_Office po = null;
			try {
				po = new Post_Office();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		PostOfficeEmployee e =  po.LoginEmployee(username, password);
    		if( e == null)
    		{
    			System.out.println("Wrong username or account");
    		}
    		else {
    			this.goToEmpAccount(s);
    		}
    		
    	}
    }

    @FXML
    void goToLoginUser(ActionEvent event)throws IOException {
    	System.out.println("Hyperlink clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/Login.fxml");
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	System.out.println("Back link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/Home.fxml");
    }
}
