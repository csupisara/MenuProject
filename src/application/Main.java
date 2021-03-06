package application;

import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Start the program.
 * @author Supisara Chuthathumpitak
 * @author Sathira Kittisukmongkol
 */
public class Main extends Application {

	/*
	 * Loads an object hierarchy from an XML document.
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
			Parent root = FXMLLoader.load(ClassLoader.getSystemResource("application/MyMain.fxml"));
			Scene scene = new Scene( root , 700 , 500 );
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Run the program.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			launch(args);
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

}