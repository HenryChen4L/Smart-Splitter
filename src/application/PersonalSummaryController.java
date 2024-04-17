package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PersonalSummaryController {

	@FXML
	private Button backButton;
	
	@FXML
	private void handleBackAction(ActionEvent event) {
		try {
			Parent backParent = FXMLLoader.load(getClass().getResource("mybill.fxml"));
			Scene scene = new Scene(backParent,400,600);
			Stage primaryStage = (Stage) backButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
