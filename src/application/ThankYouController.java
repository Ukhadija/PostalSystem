package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;

public class ThankYouController {
	Main m = new Main();
    @FXML
    private Button hbtn;
    
    public ThankYouController() {
    	
    }
    public void intialize() {
    	
    }

    @FXML
    void goToUserAccount(ActionEvent event) throws IOException {
    	System.out.println("Home button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/UserAccount.fxml");
    }

}
