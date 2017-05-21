package application;
import java.io.IOException;
import java.util.*;
public class ConsoleUI extends Observable {

	private MenuBook menuBook;
	private List<Menu> orderList;

	public ConsoleUI( MenuBook menuBook ) {
		this.menuBook = menuBook;
		orderList = new ArrayList<Menu>();
	}

	public int getCapacityOfMenuBook() {
		return menuBook.getCapacity();
	}

	public MenuBook getMenuBook() {
		return menuBook;
	}

	public List<Menu> getOrderList() {
		return orderList;
	}

	public void AddToOrderList( Menu menu ) {
		if( orderList.contains( menu ) ) {
			int indexOfThatMenu = orderList.indexOf( menu );
			orderList.get( indexOfThatMenu ).addOneAmount();
		}
		else {
			menu.addOneAmount();
			orderList.add( menu );
		}
		Collections.sort( orderList , new Comparator<Menu>() {

			@Override
			public int compare(Menu o1, Menu o2) {
				if( o1.getMenuID() > o2.getMenuID() ) {
					return +1;
				}
				else if( o1.getMenuID() < o2.getMenuID() ) {
					return -1;
				}
				else {
					return 0;
				}
			}


		} );
	}

	public int getTotalCost() {
		int total = 0;
		for( Menu eachMenu : orderList) {
			total = total + ( (eachMenu.getMenuAmount())*(eachMenu.getMenuCost()) );
		}
		return total;
	}

	public int getTotalAmount() {
		int amount = 0;
		for( Menu eachMenu : orderList ) {
			amount = amount + eachMenu.getMenuAmount();
		}
		return amount;
	}
	
	public void clearOrderList(){
		orderList.clear();
		menuBook.resetMenu();
	}

}

