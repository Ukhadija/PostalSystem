package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;

public class CustomerServiceController {
	Main m = new Main();
    @FXML
    private TextArea tArea;

    @FXML
    private Button hbtn;

    @FXML
    private TextField qtxt;

    @FXML
    private Button sbtn;
    
    public CustomerServiceController() {
    	
    }
    public void intialize() {
    	
    }

    @FXML
    void goToUserAccount(ActionEvent event)throws IOException {
    	System.out.println("Home button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/UserAccount.fxml");
    }

    @FXML
    void activateService(ActionEvent event) throws IOException{
    	System.out.println("Send button clicked");
    	
    	String query = qtxt.getText();
    	String ans = "Okii";
    	
    	String test1 = "Hi";
    	String test2 = "I have an issue";
    	String test3 = "I registered a parcel but got no confirmation";
    	String test4 = "Thankyou";
    	
    	
    	if(query.equals(test1)) {
    		ans = "Hey, Welcome to Post Office Customer Service";
    	}
    	else if (query.equals(test2)) {
    		ans = "Sure. Do Tell. We are here to help you";
    	}
    	else if (query.equals(test3) ) {
    		ans = "We will look into it and get back to you. Thanks for informing us.";
    	}
    	else if (query.equals(test4)) {
    		ans = "We are always here to help you";
    	}
    	
    	tArea.setText(ans);
    }

}
