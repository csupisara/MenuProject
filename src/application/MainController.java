package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MainController implements Initializable {

	private MenuBook menuBook;
	public ObservableList<Menu> table;
	@FXML private TableView<Menu> confirmTableView;
	@FXML private TableColumn<Menu, Integer> menuTableColumn1;
	@FXML private TableColumn<Menu, String> menuTableColumn2;
	@FXML private TableColumn<Menu, Integer> menuTableColumn3;
	@FXML private TableColumn<Menu, Integer> menuTableColumn4;

	public MainController() {
		try {
			MenuBook menuBook = new MenuBook( "EngMenu.csv" );
			menu( menuBook );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menuTableColumn1.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuID"));
		menuTableColumn2.setCellValueFactory(new PropertyValueFactory<Menu, String>("menuName"));
		menuTableColumn3.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuAmount"));
		menuTableColumn4.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuCost"));

		confirmTableView.setItems(table);
	}

	public void menu( MenuBook menuBook ) {
		this.menuBook = menuBook;
		ObservableList<Menu> list = FXCollections.observableArrayList( menuBook.getAllMenuList() );
		table = list;
	}

	@FXML private JFXButton test;

	@FXML private HBox hBox;

	@FXML private TabPane tabPane;

	@FXML //Acts as a wire that connect the FXML file with MainController.
	private Tab menuTab;

	@FXML private ButtonBar naokiButton;

	@FXML private ImageView naoki;

	@FXML private Label menuName;

	@FXML private Label price;

	@FXML private AnchorPane confirmPane;

	@FXML private AnchorPane confirmTablePane;

	@FXML private TableColumn<String, String> statusTableColumn1;

	@FXML private TableColumn<String, String> statusTableColumn2;

	@FXML private TableColumn<String, String> statusTableColumn3;

	@FXML private TableColumn<String, String> statusTableColumn4;

	@FXML private TableColumn<String, String> statusTableColumn5;

	@FXML private AnchorPane totalPane;

	@FXML
	private Button confirm;
	public void confirm(ActionEvent event){
		statusTableColumn1.setText(menuTableColumn1.getText());
		statusTableColumn2.setText(menuTableColumn2.getText());
		statusTableColumn3.setText(menuTableColumn3.getText());
		statusTableColumn4.setText(menuTableColumn4.getText());
	}

	@FXML
	private Button clear;
	public void clear(ActionEvent event){
		menuTableColumn1.setText("");
		menuTableColumn2.setText("");
		menuTableColumn3.setText("");
		menuTableColumn4.setText("");
	}

	@FXML
	private Button checkbill;
	public void checkbill(ActionEvent event){

	}

	@FXML private ScrollBar scrollbar;
	public void ScrollBar() {
		scrollbar = new ScrollBar();
		
	}

	@FXML
	private Label totalLabel;
	public void totalLabel(){
		menuTableColumn3.getText();
	}

	@FXML private Label itemLabel;

	@FXML private Tab statusTab;

	@FXML private AnchorPane statusPane;

	@FXML private ProgressIndicator progress;


}
