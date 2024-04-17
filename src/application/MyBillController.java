package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyBillController {

	@FXML
	private Button createBillButton;
	
	@FXML
	private Button personalButton;
	
	@FXML
	private void handleCreateBillAction(ActionEvent event) {
		try {
			Parent createRoot = FXMLLoader.load(getClass().getResource("createNewBill.fxml"));
			Scene scene = new Scene(createRoot,400,600);
			Stage primaryStage = (Stage) createBillButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handlePersonalAction(ActionEvent event) {
		try {
			Parent personalRoot = FXMLLoader.load(getClass().getResource("personalSummary.fxml"));
			Scene scene = new Scene(personalRoot,400,600);
			Stage primaryStage = (Stage) personalButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
