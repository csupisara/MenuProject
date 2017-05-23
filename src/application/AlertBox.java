package application;
import javafx.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.stage.Stage;

public class AlertBox {

	public static void display() {
		Stage window = new Stage();
		
		window.initModality( Modality.APPLICATION_MODAL );
		window.setTitle( "Alert Box" );
		window.setWidth( 350 );
		window.setHeight( 150 );
		
		Label label = new Label();
		label.setText( "Thank you for choosing SKE14 Restaurant.\n\t\tPay money with our Staff \n\t\t     See you next time :)" );
		
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