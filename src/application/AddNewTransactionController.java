package application;

import java.io.IOException;

import bill.Bill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import splitter.Splitter;

public class AddNewTransactionController {
	
	private Bill bill;

	@FXML
	private Button backButton;
	
	@FXML
	private Button createButton;
	
	@FXML
	private ChoiceBox<Splitter> payer;
	
	@FXML
	private TextField transactionName;
	
	@FXML
	private TextField amount;
	
	@FXML
	private TextField date;
	
	@FXML
	private void handleBackAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("billDetails.fxml"));
	        Parent billDetailParent = loader.load();
	        BillDetailsController controller = loader.getController();
	        controller.renderBillDetails(this.bill);
			Scene scene = new Scene(billDetailParent,400,600);
			Stage primaryStage = (Stage) backButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleCreateAction(ActionEvent event) {
		try {
			// create new Transaction
			Splitter paySplitter = payer.getValue();
			String name = transactionName.getText();
			Double amountNumber = Double.valueOf(amount.getText());
			String dateString = date.getText();
			bill.addNewTransaction(amountNumber, paySplitter, name, dateString);
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("billDetails.fxml"));
	        Parent billDetailParent = loader.load();
	        BillDetailsController controller = loader.getController();
	        controller.renderBillDetails(this.bill);
			Scene scene = new Scene(billDetailParent,400,600);
			Stage primaryStage = (Stage) backButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void renderPage(Bill bill) {
		this.bill = bill;
		payer.getItems().addAll(bill.getSplitterDirectory().splitterDirectory);
	}
}
