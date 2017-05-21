package application;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MainController {

//	@FXML
	
	@FXML
	private JFXButton test;
	
	@FXML
	private HBox hBox;
	
	@FXML
	private TabPane tabPane;
	
	@FXML //Acts as a wire that connect the FXML file with MainController.
	private Tab menuTab;
	
	@FXML
	private SplitPane splitPane;
	
	@FXML
	private ButtonBar naokiButton;
	
	@FXML
	private ImageView naoki;
	
	@FXML
	private Label menuName;
	
	@FXML
	private Label price;
	
	@FXML
	private AnchorPane confirmPane;
	
	@FXML
	private SplitPane confirmSplit;
	
	@FXML
	private AnchorPane confirmTablePane;
	
	@FXML
	private TableView<TableColumn<String, String>> confirmTableView;
	
	@FXML
	private TableColumn<String, String> tableColumn1;
	
	@FXML
	private TableColumn<String, String> tableColumn2;
	
	@FXML
	private TableColumn<String, String> tableColumn3;
	
	@FXML
	private TableColumn<String, String> tableColumn4;
	
	@FXML
	private TableColumn<String, String> tableColumn5;
	
	@FXML
	private AnchorPane totalPane;
	
	@FXML
	private Button confirm;
	public void confirm(ActionEvent event){
		
	}

	@FXML
	private Button clear;
	public void clear(ActionEvent event){
		
	}
	
	@FXML
	private Button checkbill;
	public void checkbill(ActionEvent event){
		
	}
	
	@FXML
	private Label totalLabel;
	
	@FXML
	private Label itemLabel;

	@FXML
	private Tab statusTab;
	
	@FXML
	private AnchorPane statusPane;

	@FXML
	private ProgressIndicator progress;
}
