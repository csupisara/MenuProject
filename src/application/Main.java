package application;

import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
			Parent root = FXMLLoader.load(ClassLoader.getSystemResource("application/MyMain.fxml"));
			Parent root2 = FXMLLoader.load(ClassLoader.getSystemResource("application/Chef.fxml"));

			Scene scene = new Scene( root , 700 , 500 );
			Scene scene2 = new Scene( root2 , 700 , 500 );

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			primaryStage.setScene(scene2);

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}