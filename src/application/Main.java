package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
//			BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(ClassLoader.getSystemResource("application/MyMain.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
//			primaryStage.setTitle( "JamieFX GUI" );
//			
//			Button button1 = new Button();
//			button1.setText( "Clicked Me!" );
//			
//			StackPane layout = new StackPane();
//			layout.getChildren().add( button1 );
//			
//			Scene scene = new Scene( layout , 300 , 250 );
//			
//			primaryStage.setScene( scene );
//			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
