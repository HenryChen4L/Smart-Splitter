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
import javafx.stage.Stage;
import transaction.Transaction;

public class TransactionDetailsController {
	private Bill bill;
	
	@FXML
	private Button backButton;
	@FXML
	private Label transactionName;
	@FXML
	private Label payerOfTheTransaction;
	@FXML
	private Label totalAmountOfTheTransaction;
	@FXML
	private Label splitters;
	@FXML
	private Label transactionTime;
	
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
	
	public void renderPage(Bill bill, Transaction transaction) {
		this.bill = bill;
		transactionName.setText(transaction.getTransactionName());
		payerOfTheTransaction.setText(transaction.getPayer().getName());
		totalAmountOfTheTransaction.setText(String.valueOf(transaction.getTotal()));
		splitters.setText(bill.getSplitterDirectory().splitterDirectory.toString().replaceAll("\\[|\\]", ""));
		transactionTime.setText(transaction.getDate());
	}
}
