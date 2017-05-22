package application;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MainController implements Initializable {

	private ObservableList<Menu> list;
	private MenuBook menuBook;
	private ConsoleUI consoleUI;
	public ObservableList<Menu> table;
	int total,item = 0;

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
	@FXML private Label totalLabel, itemLabel;

	public MainController() {
		try {
			menuBook = new MenuBook( "EngMenu.csv" );
			consoleUI = new ConsoleUI( menuBook );
			menu();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

	private void menu() {
		list = FXCollections.observableArrayList( consoleUI.getOrderList() );
		table = list;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCell();
	}
	
	public void setCell(){
		menuTableColumn1.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuID"));
		menuTableColumn2.setCellValueFactory(new PropertyValueFactory<Menu, String>("menuName"));
		menuTableColumn3.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuAmount"));
		menuTableColumn4.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuCost"));
		confirmTableView.setItems(table);
	}

	@FXML private HBox hBox;

	@FXML private TabPane tabPane;

	@FXML private AnchorPane confirmPane;

	@FXML private AnchorPane confirmTablePane;

	@FXML private AnchorPane totalPane;

	public void confirm(ActionEvent event){

	}

	public void clear(ActionEvent event){
		consoleUI.clearOrderList();
		updateDisplay();
		item = 0;
		setItem(item);
		total = 0;
		setTotal(total);
	}

	public void updateDisplay() {
		menu();
		setCell();
	}

	public void clickMenu(ActionEvent event){
		int index = 0;
		Object choosenButton = event.getSource();
		if( choosenButton.equals( button1 ) ) { }
		else if( choosenButton.equals( button2 ) ) {
			index = 1;
		}
		else if( choosenButton.equals( button3 ) ) {
			index = 2;
		}
		else if( choosenButton.equals( button4 ) ) {
			index = 3;
		}
		else if( choosenButton.equals( button5 ) ) {
			index = 4;
		}
		else if( choosenButton.equals( button6 ) ) {
			index = 5;
		}
		else if( choosenButton.equals( button7 ) ) {
			index = 6;
		}
		else if( choosenButton.equals( button8 ) ) {
			index = 7;
		}
		else if( choosenButton.equals( button9 ) ) {
			index = 8;
		}
		else if( choosenButton.equals( button10 ) ) {
			index = 9;
		}
		addOrder(index);
		totalLabel(callCost(index));
		updateDisplay();
		item++;
		setItem(item);
	}

	
	public void addOrder(int index){
		consoleUI.AddToOrderList( menuBook.getAllMenuList().get( index ) );
	}
	
	public int callCost(int index){
		return menuBook.getAllMenuList().get(index).getMenuCost();
	}

	public void totalLabel(int cost){
		total += cost;
		setTotal(total);
	}
	
	public void setTotal(int total){
		totalLabel.setText("TOTAL: " + total);
	}
	
	public void setItem(int item){
		itemLabel.setText("ITEM: " + item);
	}

	public void checkbill(ActionEvent event){
		
	}

	@FXML private Tab statusTab;

	@FXML private ProgressIndicator progress;
	
	@FXML private JFXButton test;

	@FXML private Tab menuTab;

	@FXML private Label menuName;

	@FXML private Label price;

}
