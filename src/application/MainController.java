package application;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
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

public class MainController extends Observable implements Initializable, Observer{
	
	ObservableList<Menu> list;
	private MenuBook menuBook;
	public ConsoleUI consoleUI = new ConsoleUI(menuBook);

	

	public ObservableList<Menu> table;
	
	@FXML private TableView<Menu> confirmTableView;
	@FXML private TableColumn<Menu, Integer> menuTableColumn1;
	@FXML private TableColumn<Menu, String> menuTableColumn2;
	@FXML private TableColumn<Menu, Integer> menuTableColumn3;
	@FXML private TableColumn<Menu, Integer> menuTableColumn4;
	@FXML private TableView<Menu> statusTableView;
	@FXML private TableColumn<Menu, Integer> statusTableColumn1;
	@FXML private TableColumn<Menu, String> statusTableColumn2;
	@FXML private TableColumn<Menu, Integer> statusTableColumn3;
	@FXML private TableColumn<Menu, Integer> statusTableColumn4;
	@FXML private TableColumn<Menu, Integer> statusTableColumn5;

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

	

	@FXML private AnchorPane totalPane;

	@FXML
	private Button confirm;
	public void confirm(ActionEvent event){
	}

	@FXML
	private Button clear;
	public void clear(ActionEvent event){
		notifyObservers();
	}

	@FXML
	private Button checkbill;
	public void checkbill(ActionEvent event){

	}

	@FXML private ScrollBar scrollbar;

	@FXML
	private Label totalLabel;
	public void totalLabel(){
		menuTableColumn3.getText();
	}

	@FXML private Label itemLabel;

	@FXML private Tab statusTab;

	@FXML private AnchorPane statusPane;

	@FXML private ProgressIndicator progress;

	@Override
	public void update(Observable o, Object arg) {
		consoleUI.deleteMenuInOrderList(1);
	}


}
