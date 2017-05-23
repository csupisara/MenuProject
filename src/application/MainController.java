package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

	private ObservableList<Menu> listOrder , listConfirm , tableViewOrder , tableViewConfirm;
	private MenuBook menuBook;
	private ConsoleUI consoleUI;
	private int billNumber = 1;

	@FXML private TableView<Menu> confirmTableView;
	@FXML private TableColumn<Menu, Integer> menuTableColumn1, menuTableColumn3, menuTableColumn4;
	@FXML private TableColumn<Menu, String> menuTableColumn2;

	@FXML private TableView<Menu> statusTableView;
	@FXML private TableColumn<Menu, Integer> statusTableColumn1, statusTableColumn3, statusTableColumn4, statusTableColumn5;
	@FXML private TableColumn<Menu, String> statusTableColumn2;

	@FXML private Button clear, confirm, checkbill;
	@FXML private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;;
	@FXML private Label totalLabel, itemLabel;
//	@FXML private JFXButton delete1, delete2, delete3, delete4, delete5, delete6, delete7, delete8, delete9, delete10;
	@FXML private JFXButton delete2;
	@FXML private JFXButton delete3;
	@FXML private JFXButton delete4;
	@FXML private JFXButton delete5;
	@FXML private JFXButton delete6;
	@FXML private JFXButton delete7;
	@FXML private JFXButton delete8;
	@FXML private JFXButton delete9;
	@FXML private JFXButton delete10;
	@FXML private JFXButton delete1;
	
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
		listOrder = FXCollections.observableArrayList( consoleUI.getOrderList() );
		tableViewOrder = listOrder;
		
		listConfirm = FXCollections.observableArrayList( consoleUI.getConfirmList() );
		tableViewConfirm = listConfirm;
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
		confirmTableView.setItems(tableViewOrder);
		
		statusTableColumn1.setCellValueFactory( new PropertyValueFactory<Menu, Integer>("menuID") );
		statusTableColumn2.setCellValueFactory(new PropertyValueFactory<Menu, String>("menuName"));
		statusTableColumn3.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuAmount"));
		statusTableColumn4.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuCost"));
		statusTableView.setItems(tableViewConfirm);
	}

	@FXML private HBox hBox;

	@FXML private TabPane tabPane;

	@FXML private AnchorPane confirmPane;

	@FXML private AnchorPane confirmTablePane;

	@FXML private AnchorPane totalPane;

	public void confirm(ActionEvent event){
		consoleUI.AddToConfirmList( consoleUI.getOrderList() );
		consoleUI.clearOrderList();
		updateDisplay();
	}

	public void clear(ActionEvent event){
		consoleUI.clearOrderList();
		updateDisplay();
	}

	public void updateDisplay() {
		findTotalItem();
		findTotalCost();
		menu();
		setCell();
	}

	public void clickMenu(ActionEvent event){
		int index = 0;
		if( isButton(event, button1) ) { }
		else if( isButton(event, button2) ) index = 1;
		else if( isButton(event, button3) ) index = 2;
		else if( isButton(event, button4) ) index = 3;
		else if( isButton(event, button5) ) index = 4;
		else if( isButton(event, button6) ) index = 5;
		else if( isButton(event, button7) ) index = 6;
		else if( isButton(event, button8) ) index = 7;
		else if( isButton(event, button9) ) index = 8;
		else if( isButton(event, button10) ) index = 9;
		addOrder( index );
		updateDisplay();
	}

	public boolean isButton(ActionEvent event, Button button){
		Object choosenButton = event.getSource();
		return choosenButton.equals( button ) ;
	}

	public void addOrder(int index){
		consoleUI.AddToOrderList( menuBook.getAllMenuList().get( index ) );
	}

	public void findTotalItem() {
		int totalItem = consoleUI.getTotalAmountInConfirmList();
		for( Menu eachMenu : consoleUI.getOrderList()) {
			totalItem = totalItem + eachMenu.getMenuAmount();
		}
		setTotalItem( totalItem );
	}
	
	public void findTotalCost(){
		int totalCost = consoleUI.getTotalCostInConfirmList();
		for( Menu eachMenu : consoleUI.getOrderList() ) {
			totalCost = totalCost + eachMenu.getMenuCost();
		}
		setTotalCost( totalCost );
	}

	
	public void setTotalCost(int numTotalCost){
		totalLabel.setText("TOTAL: " + numTotalCost);
	}
	
	public void setTotalItem(int numAmountItem){
		itemLabel.setText("ITEM: " + numAmountItem);
	}

	public void checkbill(ActionEvent event) {
		try {
			String today = LocalDate.now().toString();
			BufferedWriter writer = new BufferedWriter(new FileWriter(billNumber+" - "+today+".txt"));
			writer.write("Bill No."+billNumber+" \"SKE14 RESTAURANT\"\n(VAT INCLUDED)\n\n");
			for( Menu x : consoleUI.getConfirmList() ){
				writer.write( x.toString() + "\n");
			}
			writer.write("\n-----------------\n" + totalLabel.getText() + " Baht\nTHANK YOU");
			writer.close();
			billNumber++;
			AlertBox.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
		consoleUI.clearOrderList();
		consoleUI.clearConfirmList();
		setTotalCost( 0 );
		setTotalItem( 0 );
		updateDisplay();
	}
	
	public void deleteSomeMenu(ActionEvent event){
		int index = 0;
		if( isButton(event, delete1) ) { }
		else if( isButton(event, delete2) ) index = 1;
		else if( isButton(event, delete3) ) index = 2;
		else if( isButton(event, delete4) ) index = 3;
		else if( isButton(event, delete5) ) index = 4;
		else if( isButton(event, delete6) ) index = 5;
		else if( isButton(event, delete7) ) index = 6;
		else if( isButton(event, delete8) ) index = 7;
		else if( isButton(event, delete9) ) index = 8;
		else if( isButton(event, delete10) ) index = 9;
		deleteOrder(index);
		updateDisplay();
	}
	
	public void deleteOrder(int index){
		consoleUI.DeleteOrderList( menuBook.getAllMenuList().get( index ) );
	}

	@FXML private Tab menuTab;

	@FXML private Label menuName;
}
