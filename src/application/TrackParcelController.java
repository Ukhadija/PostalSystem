package application;

import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;
import java.sql.SQLException;

import Post_office_system.*;

public class TrackParcelController {
	Main m = new Main();
    @FXML
    private Button hbtn;

    @FXML
    private TextField itxt;

    @FXML
    private Button tbtn;
    
    @FXML
    private TextArea detailArea;
    
    public TrackParcelController() {
    	
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
    void goToTrackingDetails(ActionEvent event) throws IOException {
    	System.out.println("Track button clicked");
    	
    	String trackID = this.itxt.getText();
    	System.out.println("ID enetered is " + trackID);
    	if(trackID.isEmpty()) {
    		System.out.println("enter ID");
    	}
    	else {
	    	String details = ""; //get details from id
	    
	    	
	    	try {
				Post_Office po = new Post_Office();
				details = po.TrackParcel(trackID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	this.detailArea.setText(details);
	    	
	    	
	    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    	//m.changeScene(s, "resources/fxml/ShowTrackingDetails.fxml");
    	}
    }

}
