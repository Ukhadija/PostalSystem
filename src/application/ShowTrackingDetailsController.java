package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;

public class ShowTrackingDetailsController {
	Main m = new Main();
	
	public String trackingID;
	
    @FXML
    private TextArea trackingArea;

    @FXML
    private Button nbtn;
    
    public ShowTrackingDetailsController() {
    	
		
    }
    public void intialize() {
    	
    }

    public void displayID() {
    	System.out.println("SHow Tracking Details  ID: " + trackingID);

		
    	String display = "Your parcel is registered. The Tracking ID for this parcel is "+trackingID;

    	System.out.println(display);
    	
    	this.trackingArea.setText(display);
    }
    @FXML
    void goToThankYou(ActionEvent event) throws IOException {
    	System.out.println("Inventory button clicked");
    	
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/ThankYou.fxml");
    }

}
