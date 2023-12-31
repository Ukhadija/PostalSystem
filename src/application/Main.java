package application;
	
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;

import Post_office_system.*;



public class Main extends Application {
	Stage stage;
	FXMLLoader loader = new FXMLLoader();
	@Override
	public void start(Stage primaryStage) {
		try {
			String fxmlDocPath = "resources/fxml/Home.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
			
			AnchorPane root = (AnchorPane)loader.load(fxmlStream);
			
		
			Scene scene = new Scene(root,500,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void changeScene(Stage currentStage, String fxmlDocPath) throws IOException{
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root = (AnchorPane)loader.load(fxmlStream);
		
		Scene scene = new Scene(root,500,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
	
	public void changeScenewithParameter(Stage currentStage, String fxmlDocPath, Customer cus) throws IOException{
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root = (AnchorPane)loader.load(fxmlStream);
		
		UserAccountController ucontroller = loader.getController();
		
		ucontroller.setCustomer(cus);
		
		Scene scene = new Scene(root,500,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
	
	public void changeRegister(Stage currentStage, String fxmlDocPath, Customer cus) throws IOException{
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root = (AnchorPane)loader.load(fxmlStream);
		
		RegisterParcelController rcontroller = loader.getController();
		
		rcontroller.setCustomer(cus);
		
		Scene scene = new Scene(root,500,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
	
	
	public void changeInventory(Stage currentStage, String fxmlDocPath, Customer cus) throws IOException{
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root = (AnchorPane)loader.load(fxmlStream);
		
		InventoryController icontroller = loader.getController();
		
		icontroller.setCustomer(cus);
		
		Scene scene = new Scene(root,500,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
	
	public void changeCart(Stage currentStage, String fxmlDocPath, Customer cus) throws IOException{
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root = (AnchorPane)loader.load(fxmlStream);
		
		CartController Ccontroller = loader.getController();
		
		Ccontroller.setCustomer(cus);
		
		Scene scene = new Scene(root,500,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
	
	
	
	public void goToPayment(Stage currentStage, char b, String p) throws IOException{
		String fxmlDocPath = "resources/fxml/Payment.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root = (AnchorPane)loader.load(fxmlStream);
		
		PaymentController pcontroller = loader.getController();
		
		pcontroller.before = b;
		pcontroller.trackingID = p;
		
		
		Scene scene = new Scene(root,500,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
	
	public void goToShowTrackingDetails(Stage currentStage, String p) throws IOException{
		String fxmlDocPath = "resources/fxml/ShowTrackingDetails.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane root = (AnchorPane)loader.load(fxmlStream);
		
		ShowTrackingDetailsController tcontroller = loader.getController();
		
		tcontroller.trackingID = p;
		tcontroller.displayID();
		
		
		Scene scene = new Scene(root,500,500);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		currentStage.setScene(scene);
		currentStage.show();
	}
}
