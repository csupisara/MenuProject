package application;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.MenuSelectionManager;
import com.jfoenix.controls.JFXButton;
import com.sun.glass.ui.Timer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller of the FXML.
 * @author Supisara Chuthathumpitak
 * @author Sathira Kittisukmongkol
 */
public class MainController implements Initializable {

	private ObservableList<Menu> listOrder , listConfirm , tableViewOrder , tableViewConfirm;
	private MenuBook menuBook;
	private ConsoleUI consoleUI;
	private int billNumber = 1;

	@FXML private TableView<Menu> confirmTableView;
	@FXML private TableColumn<Menu, Integer> menuTableColumn1, menuTableColumn3, menuTableColumn4;
	@FXML private TableColumn<Menu, String> menuTableColumn2;

	@FXML private TableView<Menu> statusTableView;
	@FXML private TableColumn<Menu, Integer> statusTableColumn1, statusTableColumn3, statusTableColumn4;
	@FXML private TableColumn<Menu, String> statusTableColumn2, statusTableColumn5;;
	
	@FXML private Button clear, confirm, checkbill;
	@FXML private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;;
	@FXML private Label totalLabel, itemLabel;
	@FXML private JFXButton delete1, delete2, delete3, delete4, delete5, delete6, delete7, delete8, delete9, delete10;
	@FXML private Label totalAll;
	
	/**
	 * Initialize MainController
	 */
	public MainController() {
		try {
			menuBook = new MenuBook( "EngMenu.csv" );
			consoleUI = new ConsoleUI( menuBook );
			menu();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

	/**
	 * Create the array list and add to that table.
	 */
	private void menu() {
		listOrder = FXCollections.observableArrayList( consoleUI.getOrderList() );
		tableViewOrder = listOrder;

		listConfirm = FXCollections.observableArrayList( consoleUI.getConfirmList() );
		tableViewConfirm = listConfirm;
	}

	/*
	 * (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCell();
	}

	/**
	 * Set the table coulmn.
	 */
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
		statusTableColumn5.setCellValueFactory(new PropertyValueFactory<Menu, String>("status"));
		statusTableView.setItems(tableViewConfirm);
	}

	/**
	 * Send the order from order table to the status table.
	 * @param event is whats the user press.
	 */
	public void confirm(ActionEvent event){
		consoleUI.AddToConfirmList( consoleUI.getOrderList() );
		consoleUI.clearOrderList();
		updateDisplay();
		AlertBox.display("You can check your order at STATUS tab on the top.");
		setTotalAll( consoleUI.getTotalCostInConfirmList() );
		for(int i=0 ; i<consoleUI.getConfirmList().size() ; i++) {
			Menu m = consoleUI.getConfirmList().get(i);
			java.util.Timer timer = new java.util.Timer();
			try {
				if( i==0 ) {
					/* Do nothing. */
				}
				else {
					TimeUnit.SECONDS.sleep( 1*m.getMenuAmount() );					
				}
				timer.schedule( new TimerTask() {
					
					@Override
					public void run() {
						m.changeStatus();
						updateDisplay();
					}
				} , 5000 );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clear all order list from menu page.
	 * @param event is whats the user press.
	 */
	public void clear(ActionEvent event){
		consoleUI.clearOrderList();
		updateDisplay();
	}

	/**
	 * Update the display.
	 */
	public void updateDisplay() {
		findTotalItem();
		findTotalCost();
		menu();
		setCell();
		confirmTableView.refresh();
		statusTableView.refresh();
	}

	/**
	 * Get the event from the user and check the index, then call the method to add order.
	 * @param event is whats the user press.
	 */
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

	/**
	 * Check that the button that user press is which button.
	 * @param event is whats the user press.
	 * @param button is the button that want to check.
	 * @return whether it is that button or not.
	 */
	public boolean isButton(ActionEvent event, Button button){
		Object choosenButton = event.getSource();
		return choosenButton.equals( button ) ;
	}

	/**
	 * Add the menu to order list by index.
	 * @param index is the index of that menu.
	 */
	public void addOrder(int index){
		consoleUI.AddToOrderList( menuBook.getAllMenuList().get( index ) );
	}

	/**
	 * Calculate how many item are there.
	 */
	public void findTotalItem() {
		int totalItem = consoleUI.getTotalAmountInConfirmList();
		for( Menu eachMenu : consoleUI.getOrderList()) {
			totalItem = totalItem + eachMenu.getMenuAmount();
		}
		setTotalItem( totalItem );
	}
	
	/**
	 * Calculate the total cost.
	 */
	public void findTotalCost(){
		int totalCost = consoleUI.getTotalCostInConfirmList();
		for( Menu eachMenu : consoleUI.getOrderList() ) {
			totalCost = totalCost + eachMenu.getMenuCost();
		}
		setTotalCost( totalCost );
	}

	/**
	 * Set the total cost.
	 * @param numTotalCost
	 */
	public void setTotalCost(int numTotalCost){
		totalLabel.setText("TOTAL: " + numTotalCost);
	}
	
	/**
	 * Set the total item.
	 * @param numAmountItem is the number of item that user want to order.
	 */
	public void setTotalItem(int numAmountItem){
		itemLabel.setText("ITEM: " + numAmountItem);
	}

	/**
	 * Write the bill for customer.
	 * @param event is whats the user press.
	 */
	public void checkbill(ActionEvent event) {
		try {
			AlertBox.display("Thank you for choosing SKE14 Restaurant.\n\t\tPay money with our Staff \n\t\t     See you next time :)");
			String today = LocalDate.now().toString();
			BufferedWriter writer = new BufferedWriter(new FileWriter(billNumber + " - " + today + ".txt"));
			writer.write("Bill No." + billNumber + " \"SKE14 RESTAURANT\"\n(VAT INCLUDED)\n\n");
			for( Menu x : consoleUI.getConfirmList() ){
				writer.write( x.toString() + "\n");
			}
			writer.write("\n-----------------\nTOTAL: " + costAndVat( calculateVat(consoleUI.getTotalCostInConfirmList()), consoleUI.getTotalCostInConfirmList()) 
			+ " Baht\nVAT " + calculateVat(consoleUI.getTotalCostInConfirmList()) + " Baht\nTHANK YOU");
			writer.close();
			billNumber++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		consoleUI.clearOrderList();
		consoleUI.clearConfirmList();
		setTotalCost( 0 );
		setTotalItem( 0 );
		setTotalAll( 0 );
		updateDisplay();
	}
	
	/**
	 * Calculate the vat.
	 * @param total is the total cost of all food that user order.
	 * @return the vat for that cost.
	 */
	public int calculateVat(int total){
		return (int) ((int)total*0.07);
	}
	
	/**
	 * Calculate the total cost that customer need to pay.
	 * @param vat is the vat for that cost.
	 * @param cost is the total cost of all food that user order.
	 * @return the total cost which include vat.
	 */
	public double costAndVat(int vat, int cost){
		return cost + vat;
	}
	
	
	/**
	 * Get the event from the user and check the index, then call the method to delete.
	 * @param event is whats the user press.
	 */
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
	
	/**
	 * Delete the menu order that user want to cancel.
	 * @param index
	 */
	public void deleteOrder(int index){
		consoleUI.DeleteOrderList( menuBook.getAllMenuList().get( index ) );
	}
	
	/**
	 * Set total that user confirm.
	 * @param total is the total cost of all menu rhat user confirm.
	 */
	public void setTotalAll(int total){
		totalAll.setText("TOTAL: " + total);
	}
	
}
