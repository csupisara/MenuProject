package application;

import java.net.URL;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ChefController implements Initializable {

	private MenuBook menuBook;
	private static ConsoleUI consoleUI;

	private ObservableList<Menu> list;

	@FXML private TableView<Menu> chefTableView;
	@FXML private TableColumn<Menu, Integer> chefTableColumn4;
	@FXML private TableColumn<Menu, String> chefTableColumn2;
	@FXML private TableColumn<Menu, Integer> chefTableColumn1;
	@FXML private TableColumn<Menu, Integer> chefTableColumn3;
	@FXML private Label label;
	@FXML private JFXButton button;

	public ChefController() {
		if( consoleUI == null ) {
			System.out.println( "eiei from constructor Chef , console == null" );
		}
		else {
			System.out.println( "eiei from constuctor Chef , console != null" );
			setCell();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* Do nothing */
		System.out.println( "eiei from initail Chef" );
		setCell();
	}

	public void setCell(){
		if( consoleUI == null ) {
			list = FXCollections.observableArrayList( new Menu(1,"Jamie",300) );
			System.out.println( Arrays.toString( list.toArray() ) );
			chefTableColumn1.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuID"));
			chefTableColumn2.setCellValueFactory(new PropertyValueFactory<Menu, String>("menuName"));
			chefTableColumn3.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuAmount"));
			chefTableColumn4.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuCost"));
			chefTableView.setItems(list);			
		}
		else {
			list = FXCollections.observableArrayList( consoleUI.getConfirmList() );
			System.out.println( Arrays.toString( list.toArray() ) );
			chefTableColumn1.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuID"));
			chefTableColumn2.setCellValueFactory(new PropertyValueFactory<Menu, String>("menuName"));
			chefTableColumn3.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuAmount"));
			chefTableColumn4.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuCost"));
			chefTableView.setItems(list);			
		}
	}
	
	public static void setConsoleUI( ConsoleUI inputConsoleUI ) {
	consoleUI = inputConsoleUI;
	}
}
