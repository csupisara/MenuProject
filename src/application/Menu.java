package application;

import com.sun.glass.ui.Timer;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Menu extends Thread{

	private SimpleStringProperty menuName;
	private SimpleIntegerProperty menuCost;
	private SimpleIntegerProperty menuID;
	private SimpleIntegerProperty menuAmount;
	private SimpleStringProperty status ;
	private int cookTime = 5000;
	
	public Menu( int inputMenuNum , String inputName , int inputPrice ) {
		this.menuID = new SimpleIntegerProperty( inputMenuNum );
		this.menuName = new SimpleStringProperty( inputName );
		this.menuCost = new SimpleIntegerProperty( inputPrice );
		this.menuAmount = new SimpleIntegerProperty( 0 );
		this.status = new SimpleStringProperty( "Cooking" );
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
	
	public String getStatus() {
		return status.get();
	}
	
	public void addOneAmount() {
		menuAmount.set( menuAmount.get()+1 );
	}
	
	public void addManyAmount(int n) {
		menuAmount.set( menuAmount.get()+n );
	}
	
	public void deleteOneAmount() {
		menuAmount.set( menuAmount.get()-1 );
	}
	
	public void changeStatus() {
		if( status.get().equalsIgnoreCase( "Cooking" ) ) {
			status.set( "Done" );
		}
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
