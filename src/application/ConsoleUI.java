package application;
import java.io.IOException;
import java.util.*;
public class ConsoleUI extends Observable {

	private MenuBook menuBook;
	private List<Menu> orderList;
	private List<Menu> confirmList;

	public ConsoleUI( MenuBook menuBook ) {
		this.menuBook = menuBook;
		orderList = new ArrayList<Menu>();
		confirmList = new ArrayList<Menu>();
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
	
	public List<Menu> getConfirmList() {
		return confirmList;
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
	
	public void DeleteOrderList( Menu menu ) {
		if( orderList.contains( menu ) ) {
			int indexOfThatMenu = orderList.indexOf( menu );
			if(orderList.get(indexOfThatMenu).getMenuAmount() == 1) orderList.remove(menu);
			else{
				orderList.get( indexOfThatMenu ).deleteOneAmount();
			}
			
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

	public void AddToConfirmList( List<Menu> orderList ) {
		for(int i = 0 ; i < orderList.size() ; i++) {
			Menu currentMenu = orderList.get( i );
			if( isContainInConfirmListCheckByID( currentMenu ) ) {
				int indexOfThatMenu = findIndexInConfirmListCheckByID( currentMenu );
				confirmList.get( indexOfThatMenu ).addManyAmount( currentMenu.getMenuAmount() );
			}
			else {
				confirmList.add( currentMenu );
			}
		}
		Collections.sort( confirmList , new Comparator<Menu>() {

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
	
	public int getTotalCostInOrderList() {
		int total = 0;
		for( Menu eachMenu : orderList) {
			total = total + ( eachMenu.getMenuCost() );
		}
		return total;
	}

	public int getTotalCostInConfirmList() {
		int total = 0;
		for( Menu eachMenu : confirmList ) {
			total = total + ( eachMenu.getMenuCost() );
		}
		return total;
	}
	
	public int getTotalAmountInOrderList() {
		int amount = 0;
		for( Menu eachMenu : orderList ) {
			amount = amount + eachMenu.getMenuAmount();
		}
		return amount;
	}
	
	public int getTotalAmountInConfirmList() {
		int amount = 0;
		for( Menu eachMenu : confirmList ) {
			amount = amount + eachMenu.getMenuAmount();
		}
		return amount;
	}
	
	public void clearOrderList() {
		orderList.clear();
		menuBook.resetMenu();
	}
	
	public void clearConfirmList() {
		confirmList.clear();
		menuBook.resetMenu();
	}
	
	public boolean isContainInConfirmListCheckByID( Menu menu ) {
		int checkingID = menu.getMenuID();
		for(int i=0 ; i<confirmList.size() ; i++) {
			if( confirmList.get(i).getMenuID() == checkingID ) {
				return true;
			}
		}
		return false;
	}
	
	public int findIndexInConfirmListCheckByID( Menu menu ) {
		int checkingID = menu.getMenuID();
		for(int i=0 ; i<confirmList.size() ; i++) {
			if( confirmList.get(i).getMenuID() == checkingID ) {
				return i;
			}
		}
		return 0;
	}

}

