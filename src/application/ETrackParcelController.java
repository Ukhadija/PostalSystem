package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;

import Post_office_system.*;

public class ETrackParcelController {
	Main m = new Main();
	
    @FXML
    private TextField dtxt;

    @FXML
    private Button hbtn;

    @FXML
    private TextField itxt;

    @FXML
    private Button tbtn;

    
    
    public ETrackParcelController() {
    	
    }
    public void intialize() {
    	
    }

    
    @FXML
    void goToEmployeeAccount(ActionEvent event) throws IOException{
    	System.out.println("Back link clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/EmployeeAccount.fxml");
    }

    @FXML
    void addTrackingDetails(ActionEvent event) throws IOException {
    	//Add details
    	String ID = itxt.getText();
    	String Details = dtxt.getText();
    	PostOfficeEmployee e = new PostOfficeEmployee();
    	e.trackParcel(ID, Details);
    	
    	}

}
