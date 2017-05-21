package application;
<<<<<<< HEAD
import javafx.*;
import javafx.fxml.Initializable;
=======

>>>>>>> a5e547dc4986a29f2ba1bc72c9c02d1e15eadc80
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		//BorderPane root = new BorderPane();

//		Image image = new Image(getClass().getResourceAsStream("sushi.jpg"));
//
//		Button button = new Button("Naoki", new ImageView(image));
//
//		button.setOnAction(e -> System.out.println("naoki"));
//		HBox layout = new HBox();
//		layout.getChildren().addAll(button);

		try {
			Parent root = FXMLLoader.load(ClassLoader.getSystemResource("application/MyMain.fxml"));
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
