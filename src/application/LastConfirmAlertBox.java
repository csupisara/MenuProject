package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LastConfirmAlertBox {

	private static boolean controlCooking;
	
	public static void display(){
		Stage window = new Stage();

		window.initModality( Modality.APPLICATION_MODAL );
		window.setTitle( "Alert Box" );
		window.setWidth( 400 );
		window.setHeight( 230 );

		Label label1 = new Label();
		label1.setText( "You can check your order at STATUS tab on the top." );
		Label label2 = new Label();
		label2.setText( "Press Confirm to confirm your menu." );
		Label label3 = new Label();
		label3.setText( "Press Cancel to cancel your menu." );

		Button confirmButton = new Button();
		confirmButton.setText( "Confirm" );
		confirmButton.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				controlCooking = true;
				window.close();
			}
		});
		Button cancelButton = new Button();
		cancelButton.setText( "Cancel" );
		cancelButton.setOnAction( new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				controlCooking = false;
				window.close();
			}
		} );

		VBox layoutVertical = new VBox( 10 );
		layoutVertical.getChildren().addAll( label1, label2, label3, confirmButton, cancelButton  );
		layoutVertical.setAlignment( Pos.CENTER );

		Scene sceneVertical = new Scene( layoutVertical );
		window.setScene( sceneVertical );
		window.showAndWait();
	}
	
	public static boolean shouldCook() {
		return controlCooking;
	}
	
}
