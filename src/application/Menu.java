package application;

import com.sun.glass.ui.Timer;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Composition for each menu.
 * @author Supisara Chuthathumpitak
 * @author Sathira Kittisukmongkol
 */
public class Menu {

	private SimpleStringProperty menuName;
	private SimpleIntegerProperty menuCost;
	private SimpleIntegerProperty menuID;
	private SimpleIntegerProperty menuAmount;
	private SimpleStringProperty status ;
	private int cookTime = 5000;
	
	/**
	 * Initialize the Menu.
	 * @param inputMenuNum is the ID of menu.
	 * @param inputName is the name of menu.
	 * @param inputPrice is the price of menu.
	 */
	public Menu( int inputMenuNum , String inputName , int inputPrice ) {
		this.menuID = new SimpleIntegerProperty( inputMenuNum );
		this.menuName = new SimpleStringProperty( inputName );
		this.menuCost = new SimpleIntegerProperty( inputPrice );
		this.menuAmount = new SimpleIntegerProperty( 0 );
		this.status = new SimpleStringProperty( "Cooking" );
	}
	
	/**
	 * Get the name of this menu.
	 * @return name of it
	 */
	public String getMenuName() {
		return menuName.get();
	}
	
	/**
	 * Get this menu price. 
	 * @return the cost of it.
	 */
	public int getMenuCost() {
		return menuCost.get()*menuAmount.get();
	}
	
	/**
	 * The ID of that menu.
	 * @return the ID of it.
	 */
	public int getMenuID() {
		return menuID.get();
	}
	
	/**
	 * Get the amount that customer order.
	 * @return the amount of it
	 */
	public int getMenuAmount() {
		return menuAmount.get();
	}
	
	/**
	 * Add amount of this menu.
	 * @param amount is the amount that want to add to this menu.
	 */
	public void addAmount(int amount) {
		menuAmount.set( menuAmount.get() + amount );
	}
	
	/**
	 * Delete amount just 1
	 */
	public void deleteOneAmount(){
		menuAmount.set( menuAmount.get()-1 );
	}
	
	/**
	 * The result that want to write in the bill.
	 */
	public String toString() {
		String name = menuName.get();
		int cost = menuCost.get()*menuAmount.get();
		int amount = menuAmount.get();
		String sentence = (amount + " " + name + "    " + cost + " baht\n") ;
		return sentence;
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
	
	public void changeStatus() {
		if( status.get().equalsIgnoreCase( "Cooking" ) ) {
			status.set( "Done" );
		}
	}

}
