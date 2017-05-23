package application;

import java.net.URL;
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

public class ChefController implements Initializable{
	
	private MenuBook menuBook;
	private ConsoleUI consoleUI;
	
	private ObservableList<Menu> list;

	@FXML private TableView<Menu> chefTableView;
	@FXML private TableColumn<Menu, Integer> chefTableColumn4;
	@FXML private TableColumn<Menu, String> chefTableColumn2;
	@FXML private TableColumn<Menu, Integer> chefTableColumn1;
	@FXML private TableColumn<Menu, Integer> chefTableColumn3;
	@FXML private Label label;
	@FXML private JFXButton button;
	
	public ChefController() {
		try {
			menuBook = new MenuBook( "EngMenu.csv" );
			consoleUI = new ConsoleUI( menuBook );
			menu();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

	private void menu() {
//		list = FXCollections.observableArrayList( consoleUI.getConfirmList() );
//		tableViewOrder = listOrder;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		setCell();
	}
	
	public void setCell(){
		list = FXCollections.observableArrayList( consoleUI.getConfirmList() );

//		chefTableColumn1.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("table"));
		chefTableColumn2.setCellValueFactory(new PropertyValueFactory<Menu, String>("menuName"));
		chefTableColumn3.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("menuAmount"));
//		chefTableColumn4.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("description"));
		chefTableView.setItems(list);
	}
}
