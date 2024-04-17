package application;

import java.io.IOException;
import java.util.Map;

import bill.Bill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import splitter.Splitter;

public class BillTransactionsController {
	
	private Bill bill;
	
	@FXML
	private Button backButton;
	
	@FXML
	private AnchorPane list;
	
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
	
	public void renderPage(Bill bill) {
		this.bill = bill;
		VBox listBox = new VBox(10);
		Font font = new Font("Arial", 15);
		for(Map.Entry<Splitter[], Double> entry : bill.getStatementMap().entrySet()) {
			if(entry.getValue() < 0) {
				Label statementLabel = new Label(entry.getKey()[0].toString() + " -> " + entry.getKey()[1].toString() + ": " + Math.abs(entry.getValue()));
				statementLabel.setFont(font);
				listBox.getChildren().add(statementLabel);
			} else {
				Label statementLabel = new Label(entry.getKey()[1].toString() + " -> " + entry.getKey()[0].toString() + ": " + Math.abs(entry.getValue()));
				statementLabel.setFont(font);
				listBox.getChildren().add(statementLabel);
			}
		}
		
		AnchorPane.setTopAnchor(listBox, 20.0);
        AnchorPane.setRightAnchor(listBox, 20.0);
        AnchorPane.setBottomAnchor(listBox, 20.0);
        AnchorPane.setLeftAnchor(listBox, 20.0);
        list.getChildren().add(listBox);
	}
}
