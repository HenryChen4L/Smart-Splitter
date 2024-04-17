package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BillDetailsController {
	
	@FXML
	private Button backButton;
	
	@FXML
	private void handleBackAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("mybill.fxml"));
	        Parent homepage = loader.load();
	        MyBillController controller = loader.getController();
	        controller.renderPage();
			Scene scene = new Scene(homepage,400,600);
			Stage primaryStage = (Stage) backButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
