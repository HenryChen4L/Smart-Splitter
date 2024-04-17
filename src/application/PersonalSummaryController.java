package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import user.User;

public class PersonalSummaryController {

	@FXML
	private Button backButton;
	
	@FXML
	private Label netBalance;
	
	@FXML
	private Label totalIncome;
	
	@FXML
	private Label totalExpenses;
	
	@FXML
	private void handleBackAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("mybill.fxml"));
	        Parent backParent = loader.load();
	        MyBillController controller = loader.getController();
	        controller.renderPage();			
	        Scene scene = new Scene(backParent,400,600);
			Stage primaryStage = (Stage) backButton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void renderPage(User user) {
		Double totalIncomeDouble = user.getTotalIncome();
		Double totalExpensesDouble = user.getTotalExpense();
		netBalance.setText(String.valueOf(totalExpensesDouble - totalIncomeDouble));
		totalIncome.setText(String.valueOf(totalIncomeDouble));
		totalExpenses.setText(String.valueOf(totalExpensesDouble));
	}
}
