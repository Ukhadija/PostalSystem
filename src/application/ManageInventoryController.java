package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.io.*;
import java.sql.SQLException;

import Post_office_system.*;

public class ManageInventoryController {
	Main m = new Main();
	
	@FXML
    private TextArea t1;

    @FXML
    private TextArea t2;
    
    @FXML
    private TextArea t3;
    
    @FXML
    private TextArea t4;

    @FXML
    private TextArea t5;
    
    @FXML
    private TextArea t6;
	
    @FXML
    private Button hbtn;

    @FXML
    private Button rbtn;
    
    public ManageInventoryController() {
    	
    }
    public void intialize() {
    	
    }

    @FXML
    void restockInventory(ActionEvent event) throws IOException{
    		//call restock inventory function
    	PostOfficeEmployee emp =  new PostOfficeEmployee();
    	try {
			emp.manageInventory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void goToEmployeeAccount(ActionEvent event) throws IOException {
    	System.out.println("Home btn clicked");
    	Stage s = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	m.changeScene(s, "resources/fxml/EmployeeAccount.fxml");
    }

}
