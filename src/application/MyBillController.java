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
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyBillController {

	@FXML
	private Button createBillButton;
	
	@FXML
	private Button personalButton;
	
	@FXML
	private AnchorPane list;
	
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
	
	public void handleViewBill(Bill bill) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("billDetails.fxml"));
	        Parent billDetailParent = loader.load();
	        BillDetailsController controller = loader.getController();
	        controller.renderBillDetails(bill);
			Scene scene = new Scene(billDetailParent,400,600);
			Stage primaryStage = (Stage) createBillButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void renderPage() {
		VBox listBox = new VBox(20);
		Font font = new Font("Arial", 13);

        for (Bill bill : Main.business.getCurrentUser().getBillDirectory().billDirectory) {
            VBox itemBox = new VBox(10);
            HBox nameBox = new HBox(5);
            Label nameLabel = new Label("Bill Name:");
            nameLabel.setFont(font);
            Text nameText = new Text(bill.getBillName());
            nameText.setFont(font);
            nameBox.getChildren().addAll(nameLabel, nameText);
            HBox amountBox = new HBox(5);
            Label amountLabel = new Label("Total Amount:");
            amountLabel.setFont(font);
            Text amountText = new Text(String.valueOf(bill.getBalance()));
            amountText.setFont(font);
            amountBox.getChildren().addAll(amountLabel, amountText);
            HBox splitterBox = new HBox(5);
            Label splitterLabel = new Label("Splitters:");
            splitterLabel.setFont(font);
            Text splitterText = new Text(bill.getSplitterDirectory().splitterDirectory.toString());
            splitterText.setFont(font);
            splitterBox.getChildren().addAll(splitterLabel, splitterText);
            Button button = new Button("View Bill >");
            button.setPrefSize(140, 40);
            button.setOnAction(e -> handleViewBill(bill));

            itemBox.getChildren().addAll(nameBox, amountBox, splitterBox, button);
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
