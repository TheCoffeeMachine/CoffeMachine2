package application;
	
import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = FXMLLoader.load(getClass().getResource("CofeeMachineXML.xml"));
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}