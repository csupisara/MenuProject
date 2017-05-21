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

	public int getCapacityOfMenu() {
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
			orderList.remove( menu );
			orderList.add( menu );
		}
		else {
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
		setChanged();
		notifyObservers();
		System.out.println( toStringFromOrderList() );
	}

	public String toStringFromOrderList() {
		String s = "";
		for( Menu x : orderList ) {
			s = s.concat( " "+x.toString()+"\n" );
		}
		return s;
	}

//	public int getTotalCost() {
//		int x = 0;
//		for( Menu y : orderList) {
//			x = x + (y.getMenuCost()*y.getAmount()) ;
//		}
//		return x;
//	}

//	public int getTotalAmount() {
//		int x = 0;
//		for( Menu y : orderList ) {
//			x = x + y.getAmount();
//		}
//		return x;
//	}

//	public void setNewOrderList() {
//		orderList.clear();
//		menuBook.resetMenu();
//		setChanged();
//		notifyObservers();
//	}

//	public void setAmountMenuInOrderList( int ID , int amount ) {
//		if( orderList.contains( menuBook.getAllMenuList().get( ID ) ) ) {
//			int indexInOrderList = orderList.indexOf( menuBook.getAllMenuList().get( ID ) );
//			orderList.get( indexInOrderList ).setAmount( amount );
//		}
//		else {
//				orderList.add( menuBook.getAllMenuList().get( ID ) );				
//		}
//		setChanged();
//		notifyObservers();
//	}
	
//	public void deleteMenuInOrderList( int ID ) {
//		int indexDelete = orderList.indexOf( menuBook.getAllMenuList().get(ID) );
//		orderList.remove( indexDelete );
//		setChanged();
//		notifyObservers();
//	}

}