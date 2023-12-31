package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;

public class EmployeeAccountController {
	Main m = new Main();
    @FXML
    private Button Lbtn;

    @FXML
    private Button cbtn;

    @FXML
    private Button mbtn;
    
    @FXML
    private Button tbtn;
    
    
    
    public EmployeeAccountController() {
    	
    }
    public void intialize() {
    	
    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
    	System.out.println("Back link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/Home.fxml");
    }

    @FXML
    void goToManageInventory(ActionEvent event) throws IOException{
    	System.out.println("Manage Inventory button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/ManageInventory.fxml");
    }

    @FXML
    void goToEtrackParcel(ActionEvent event) throws IOException {
    	System.out.println("Track Parcel button clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/ETrackParcel.fxml");
    }

}
