package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Menu {

	private SimpleStringProperty menuName;
	private SimpleIntegerProperty menuCost;
	private SimpleIntegerProperty menuID;
	private SimpleIntegerProperty menuAmount;
	
	public Menu( int inputMenuNum , String inputName , int inputPrice ) {
		super();
		this.menuID = new SimpleIntegerProperty( inputMenuNum );
		this.menuName = new SimpleStringProperty( inputName );
		this.menuCost = new SimpleIntegerProperty( inputPrice );
		this.menuAmount = new SimpleIntegerProperty( 0 );
	}
	
	public String getMenuName() {
		return menuName.get();
	}
	
	public int getMenuCost() {
		return menuCost.get();
	}
	
	public int getMenuID() {
		return menuID.get();
	}
	
	public int getMenuAmount() {
		return menuAmount.get();
	}
	
}
