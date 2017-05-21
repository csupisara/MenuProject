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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MainController extends Observable implements Initializable, Observer{
	
	private ObservableList<Menu> list;
	private MenuBook menuBook;
	private ConsoleUI consoleUI = new ConsoleUI(menuBook);
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
	@FXML private Button clear;
	@FXML private Button confirm;
	@FXML private Button checkbill;
	@FXML private Button button1;
	@FXML private Button button2;
	@FXML private Button button3;
	@FXML private Button button4;
	@FXML private Button button5;
	@FXML private Button button6;
	@FXML private Button button7;
	@FXML private Button button8;
	@FXML private Button button9;
	@FXML private Button button10;

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
		list = FXCollections.observableArrayList( menuBook.getAllMenuList() );
		table = list;
	}

	
	public void confirm(ActionEvent event){
	}

	public void clear(ActionEvent event){
		consoleUI.clearOrderList();
		menuBook.resetMenu();
		setChanged();
		notifyObservers();
	}

	public void clickMenu(ActionEvent event){
		System.out.println("ccc");
		System.out.println(event.toString());
		
	}
	
	public void checkbill(ActionEvent event){

	}

	public void totalLabel(){
		menuTableColumn3.getText();
	}

	@FXML private Label totalLabel;
	@FXML private Label itemLabel;

	@FXML private Tab statusTab;

	@FXML private ProgressIndicator progress;
	
	@FXML private JFXButton test;

	@FXML private Tab menuTab;

	@FXML private Label menuName;

	@FXML private Label price;

	@Override
	public void update(Observable o, Object arg) {
		consoleUI.deleteAllMenuInOrderList();
	}


}
