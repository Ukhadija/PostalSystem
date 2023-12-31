package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.*;

public class HomeController {
	Main m = new Main();
    @FXML
    private Button Lbtn;

    @FXML
    private Button Sbtn;
    
    public HomeController() {
    	
    }
    public void intialize() {
    	
    }

    @FXML
    void goToLogin(ActionEvent event) throws IOException {
    	System.out.println("Login button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/Login.fxml");
    }

    @FXML
    void goToSignUp(ActionEvent event) throws IOException {
    	System.out.println("SignUp button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/SignUp.fxml");
    }

}
