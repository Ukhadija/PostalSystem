package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;
import java.sql.SQLException;

import javafx.event.ActionEvent;

import Post_office_system.*;

public class SignUpController {
	Main m = new Main();
	
    @FXML
    private TextArea tArea;
	
    @FXML
    private TextField ntxt;

    @FXML
    private TextField atxt;

    @FXML
    private TextField numtxt;

    @FXML
    private TextField ctxt;

    @FXML
    private TextField etxt;

    @FXML
    private PasswordField ptxt;

    @FXML
    private PasswordField cptxt;

    @FXML
    private Hyperlink blink;

    @FXML
    private Button btn;

    @FXML
    private TextField utxt;
    
    public SignUpController() {
    	
    }
    public void intialize() {
    	
    }
    
    void goToLogin(Stage s)throws IOException {
    	m.changeScene(s, "resources/fxml/Login.fxml");
    }

    @FXML
    void SIgnUp(ActionEvent event) throws IOException {
    	System.out.println("SignUp button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	
    	String name = ntxt.getText();
    	String add = atxt.getText();
    	String phone = numtxt.getText();
    	String email = etxt.getText();
    	String cnic = ctxt.getText();
    	
    	String username = utxt.getText();
    	String password = ptxt.getText();
    	String verifypass = cptxt.getText();
    	
    	if(username.isEmpty()|| password.isEmpty() || name.isEmpty()|| add.isEmpty() || phone.isEmpty()|| email.isEmpty() || cnic.isEmpty()|| verifypass.isEmpty()) {
    		System.out.println ("enter values");
    	}
    	else if(!password.equals(verifypass)) {
    		System.out.println ("Passwords do not match");
    		tArea.setText("Passwords do not Match");
    	}
    	else {
    		System.out.println("Name is "+name);
    		System.out.println("Address is "+add);
    		System.out.println("Email is "+email);
    		System.out.println("CNIC is "+cnic);
    		System.out.println("Phone Number is "+phone);
    		
    		System.out.println("Username is "+username);
    		System.out.println("Password is "+password);
    		
    		try {
				Post_Office po = new Post_Office();
				po.CreateAccount(name, add, email, phone, cnic, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		this.goToLogin(s);
    	}
    }

    @FXML
    void goToHome(ActionEvent event)throws IOException {
    	System.out.println("Back link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/Home.fxml");
    }

}
