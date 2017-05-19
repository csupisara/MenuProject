package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {

	@FXML //Acts as a wire that connect the FXML file with MainController.
	//	private Label myMessage;
	private Tab menu;

	@FXML
	private Tab status;

	@FXML
	private TableColumn<String, String> check;

	@FXML
	private TableColumn<String, String> order;

	@FXML
	private TableColumn<String, String> picture;

	@FXML
	private TableColumn<String, String> price;

	@FXML
	private ProgressIndicator progress;

	@FXML
	private Button confirm;
	public void confirm(ActionEvent event){

	}

	@FXML
	private Button clear;
	public void clear(ActionEvent event){
		
	}
	
	@FXML
	private TableView<TableColumn> table;
	
	@FXML
	private SplitPane myMenu;
}
