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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import transaction.Transaction;

public class BillDetailsController {
	
	private Bill bill;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button viewDetailButton;
	
	@FXML
	private Button createTransactionButton;
	
	@FXML
	private AnchorPane list;
	
	@FXML
	private Label billTotalAmount;
	
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
	
	@FXML
	private void handleViewDetailAction(ActionEvent event) {
		try {
			Parent billTransactionParent = FXMLLoader.load(getClass().getResource("billTransactions.fxml"));
			Scene scene = new Scene(billTransactionParent,400,600);
			Stage primaryStage = (Stage) viewDetailButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleCreateTransactionAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("addNewLedgerEntry.fxml"));
	        Parent newTransactionParent = loader.load();
	        AddNewTransactionController controller = loader.getController();
	        controller.renderPage(bill);			
	        Scene scene = new Scene(newTransactionParent,400,600);
			Stage primaryStage = (Stage) createTransactionButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void handleViewTransactionDetail(Transaction transaction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("transactionDetails.fxml"));
	        Parent transactionParent = loader.load();
	        TransactionDetailsController controller = loader.getController();
	        controller.renderPage(bill, transaction);			
	        Scene scene = new Scene(transactionParent,400,600);
			Stage primaryStage = (Stage) createTransactionButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void renderBillDetails(Bill bill) {
		this.bill = bill;
		billTotalAmount.setText(String.valueOf(bill.getBalance()));
		VBox listBox = new VBox(20);
		Font font = new Font("Arial", 13);

        for (Transaction transaction: bill.getTransactionDirectory().transactionDirectory) {
            VBox itemBox = new VBox(10);
            HBox dateBox = new HBox(5);
            Label dateLabel = new Label("Transaction Date:");
            dateLabel.setFont(font);
            Text dateText = new Text(transaction.getDate());
            dateText.setFont(font);
            dateBox.getChildren().addAll(dateLabel, dateText);
            HBox nameBox = new HBox(5);
            Label nameLabel = new Label("Transaction Name:");
            nameLabel.setFont(font);
            Text nameText = new Text(transaction.getTransactionName());
            nameText.setFont(font);
            nameBox.getChildren().addAll(nameLabel, nameText);
            HBox amountBox = new HBox(5);
            Label amountLabel = new Label("Total Amount:");
            amountLabel.setFont(font);
            Text amountText = new Text(String.valueOf(transaction.getTotal()));
            amountText.setFont(font);
            amountBox.getChildren().addAll(amountLabel, amountText);
            HBox splitterBox = new HBox(5);
            Label splitterLabel = new Label("Splitters:");
            splitterLabel.setFont(font);
            Text splitterText = new Text(bill.getSplitterDirectory().splitterDirectory.toString().replaceAll("\\[|\\]", ""));
            splitterText.setFont(font);
            splitterBox.getChildren().addAll(splitterLabel, splitterText);
            Button button = new Button("View Transaction >");
            button.setPrefSize(140, 40);
            button.setOnAction(e -> handleViewTransactionDetail(transaction));

            itemBox.getChildren().addAll(dateBox, nameBox, amountBox, splitterBox, button);
            itemBox.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-background-color: white; -fx-padding: 10;");
            
            listBox.getChildren().add(itemBox);
        }

        AnchorPane.setTopAnchor(listBox, 20.0);
        AnchorPane.setRightAnchor(listBox, 20.0);
        AnchorPane.setBottomAnchor(listBox, 20.0);
        AnchorPane.setLeftAnchor(listBox, 20.0);
        list.getChildren().add(listBox);
	}
	
	
}
