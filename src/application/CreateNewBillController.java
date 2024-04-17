package application;

import java.io.IOException;

import bill.Bill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateNewBillController {
	
	@FXML
	private Button createButton;
	
	@FXML
	private Button backButton;
	
	@FXML
	private TextField createBillName;
	
	@FXML
	private TextField textPayers;
	
	@FXML
	private void handleCreateAction(ActionEvent event) {
		try {
			// create new Bill
			String billName = createBillName.getText();
			String[] billPayer = textPayers.getText().split(", ");
			Bill bill = Main.business.getCurrentUser().getBillDirectory().createNewBill(billName);
			for(String payer: billPayer) {
				bill.getSplitterDirectory().addNewSplitter(payer);
			}
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("mybill.fxml"));
	        Parent homepage = loader.load();
	        MyBillController controller = loader.getController();
	        controller.renderPage();
			Scene scene = new Scene(homepage,400,600);
			Stage primaryStage = (Stage) createButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleBackAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("mybill.fxml"));
	        Parent homepage = loader.load();
	        MyBillController controller = loader.getController();
	        controller.renderPage();
			Scene scene = new Scene(homepage,400,600);
			Stage primaryStage = (Stage) createButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
