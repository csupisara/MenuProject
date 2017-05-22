package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Menu {

	private SimpleStringProperty menuName;
	private SimpleIntegerProperty menuCost;
	private SimpleIntegerProperty menuID;
	private SimpleIntegerProperty menuAmount;
	
	public Menu( int inputMenuNum , String inputName , int inputPrice ) {
		this.menuID = new SimpleIntegerProperty( inputMenuNum );
		this.menuName = new SimpleStringProperty( inputName );
		this.menuCost = new SimpleIntegerProperty( inputPrice );
		this.menuAmount = new SimpleIntegerProperty( 0 );
	}
	
	public String getMenuName() {
		return menuName.get();
	}
	
	public int getMenuCost() {
		return menuCost.get()*menuAmount.get();
	}
	
	public int getMenuID() {
		return menuID.get();
	}
	
	public int getMenuAmount() {
		return menuAmount.get();
	}
	
	public void addOneAmount() {
		menuAmount.set( menuAmount.get()+1 );
	}
	
	public void addManyAmount(int n) {
		menuAmount.set( menuAmount.get()+n );
	}
	
	public String toString() {
		int id = menuID.get();
		String name = menuName.get();
		int cost = menuCost.get()*menuAmount.get();
		int amount = menuAmount.get();
		String sentence = ("ID: "+id+", Name: "+name+", Cost: "+cost+", Amount: "+amount+"\n") ;
		return sentence;
	}
	
}
