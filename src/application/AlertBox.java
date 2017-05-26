package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.stage.Stage;

/**
 * AlertBox when some button is pressed.
 * @author Supisara Chuthathumpitak
 * @author Sathira Kittisukmongkol
 */
public class AlertBox {

	/**
	 * Display the alert box.
	 * @param text, The sentence that will be shown in the window.
	 */
	public static void display(String text){
		Stage window = new Stage();

		window.initModality( Modality.APPLICATION_MODAL );
		window.setTitle( "Alert Box" );
		window.setWidth( 400 );
		window.setHeight( 150 );

		Label label = new Label();
		label.setText(text);

		Button closeButton = new Button();
		closeButton.setText( "Close This Window" );
		closeButton.setOnAction( new  EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		} );

		VBox layout = new VBox( 10 );
		layout.getChildren().addAll( label , closeButton );
		layout.setAlignment( Pos.CENTER );

		Scene scene = new Scene( layout );
		window.setScene( scene );
		window.showAndWait();
	}
}
