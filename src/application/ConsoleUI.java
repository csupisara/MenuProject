package application;
import java.util.*;

/**
 * Staff simulator that manage all order that customers order.
 * @author Supisara Chuthathumpitak
 * @author Sathira Kittisukmongkol
 */
public class ConsoleUI {

	private MenuBook menuBook;
	private List<Menu> orderList;
	private List<Menu> confirmList;

	/**
	 * Initialize constructor of ConsoleUI.
	 * @param menuBook.
	 */
	public ConsoleUI( MenuBook menuBook ) {
		this.menuBook = menuBook;
		orderList = new ArrayList<Menu>();
		confirmList = new ArrayList<Menu>();
	}

	/**
	 * Get the amount of menu in menubook.
	 * @return the amount in menubook.
	 */
	public int getCapacityOfMenuBook() {
		return menuBook.getCapacity();
	}

	/**
	 * Get the menuBook that contains all menu.
	 * @return menuBook, menuBook object.
	 */
	public MenuBook getMenuBook() {
		return menuBook;
	}
	
	/**
	 * Get the list of ordered menu.
	 * @return orderList , the list of ordered menu.
	 */
	public List<Menu> getOrderList() {
		return orderList;
	}
	
	/**
	 * Get the list of confirmed menu.
	 * @return confirmList, the list of menu that customers have confirmed.
	 */
	public List<Menu> getConfirmList() {
		return confirmList;
	}

	/**
	 * Add input menu into order list.
	 * @param menu, menu that customers want to order.
	 */
	public void AddToOrderList( Menu menu ) {
		if( orderList.contains( menu ) ) {
			int indexOfThatMenu = orderList.indexOf( menu );
			orderList.get( indexOfThatMenu ).addAmount(1);
		}
		else {
			menu.addAmount(1);
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
	
	/**
	 * Delete input menu in the order list.
	 * @param menu, menu that customers want to remove from the order list.
	 */
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

	/*
	 * Change order list to be confirm list.
	 */
	public void AddToConfirmList( List<Menu> orderList ) {
		for(int i = 0 ; i < orderList.size() ; i++) {
			Menu currentMenu = orderList.get( i );
			if( isContainInConfirmListCheckByID( currentMenu ) ) {
				int indexOfThatMenu = findIndexInConfirmListCheckByID( currentMenu );
				confirmList.get( indexOfThatMenu ).addAmount( currentMenu.getMenuAmount() );
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
	
	/**
	 * Get the total cost in the order list.
	 * @return total, total cost in the order list.
	 */
	public int getTotalCostInOrderList() {
		int total = 0;
		for( Menu eachMenu : orderList) {
			total = total + ( eachMenu.getMenuCost() );
		}
		return total;
	}

	/**
	 * Get the total cost in the confirm list.
	 * @return total, total cost in the confirm list.
	 */
	public int getTotalCostInConfirmList() {
		int total = 0;
		for( Menu eachMenu : confirmList ) {
			total = total + ( eachMenu.getMenuCost() );
		}
		return total;
	}
	
	/**
	 * Get the total amount of menu in the order list.
	 * @return amount, total amount in the order list.
	 */
	public int getTotalAmountInOrderList() {
		int amount = 0;
		for( Menu eachMenu : orderList ) {
			amount = amount + eachMenu.getMenuAmount();
		}
		return amount;
	}
	
	/**
	 * Get the total amount of menu in the confirm list.
	 * @return amount, total amount in the confirm list.
	 */
	public int getTotalAmountInConfirmList() {
		int amount = 0;
		for( Menu eachMenu : confirmList ) {
			amount = amount + eachMenu.getMenuAmount();
		}
		return amount;
	}
	
	/**
	 * Clear all items in the order list.
	 */
	public void clearOrderList() {
		orderList.clear();
		menuBook.resetMenu();
	}
	
	/**
	 * Clear all items in the confirm list.
	 */
	public void clearConfirmList() {
		confirmList.clear();
		menuBook.resetMenu();
	}
	
	/**
	 * Check that is input menu contain in confirm list by ID?
	 * @param menu, menu that want to check.
	 * @return true if it contains, false it doesn't.
	 */
	public boolean isContainInConfirmListCheckByID( Menu menu ) {
		int checkingID = menu.getMenuID();
		for(int i=0 ; i<confirmList.size() ; i++) {
			if( confirmList.get(i).getMenuID() == checkingID ) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Find the index of input menu in the confirm list by ID.
	 * @param menu, menu that want to find.
	 * @return i, index of that menu and 0 if it's not found.
	 */
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

