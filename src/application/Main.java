package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static Business business = new Business();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("mybill.fxml"));
	        Parent root = loader.load();
	        MyBillController controller = loader.getController();
	        controller.renderPage();
	        primaryStage.setTitle("Smart Splitter");
			Scene scene = new Scene(root,400,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		initialize();
		launch(args);
	}
	
	public static void initialize() {
		business.initialize();
		System.out.println("initialized successfully");
	}
}
