package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Menubook shows all menu in the restaurant.
 * This class creates all menu from EngMenu.csv file.
 * @author Supisara Chuthathumpitak
 * @author Sathira Kittisukmongkol
 */
public class MenuBook {

	private InputStream inputStream;
	private BufferedReader buffReader;

	private String readLine;
	private int capacity = 0;
	private String fileName;

	private ArrayList<Menu> list;
	private List<Integer> readID;
	private List<String> readMenu;
	private List<Integer> readPrice;

	/**
	 * Constructor of this class.
	 */
	public MenuBook() {
		try {
			list = new ArrayList<Menu>();
			readID = new ArrayList<Integer>();
			readMenu = new ArrayList<String>();
			readPrice = new ArrayList<Integer>();
			createMenu();	
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

	/**
	 * Read EngMenu.csv file and create all menu.
	 */
	private void createMenu() {
		try {
			this.inputStream = getClass().getResource("/application/EngMenu.csv").openStream(); 
			buffReader = new BufferedReader( new InputStreamReader( inputStream ) );

			readLine = buffReader.readLine();

			while( readLine!=null ) {
				String[] tempBox = readLine.split( "," );
				int id = Integer.parseInt( tempBox[0].trim() );
				String name = tempBox[1].substring( 1 , tempBox[1].length() );
				int price = Integer.parseInt( tempBox[2].trim() );
				readID.add( id );
				readMenu.add( name );
				readPrice.add( price );
				readLine = buffReader.readLine();
			}

			for( int i=0 ; i<readID.size() ; i++ ) {
				list.add( new Menu( readID.get(i) , readMenu.get(i) , readPrice.get(i) ) );
				capacity++;
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

	/**
	 * Get all menu in the book.
	 * @return list, Arrayslist that contains all menu in the book.
	 */
	public ArrayList<Menu> getAllMenuList() {
		return list;
	}

	/**
	 * Get all ID's menu in the book.
	 * @return box, array of ID's menu in the book.
	 */
	public int[] getIDArray() {
		int[] box = new int[ readID.size() ];
		for(int i=0;i<box.length;i++) {
			box[i] = readID.get(i);
		}
		return box;
	}

	/**
	 * Get all Name's menu in the book.
	 * @return box, array of ID's menu in the book.
	 */
	public String[] getMenuArray() {
		String[] box = new String[ readMenu.size() ];
		for(int i=0;i<box.length;i++) {
			box[i] = readMenu.get(i);
		}
		return box;
	}

	/**
	 * Get all Price's menu in the book.
	 * @return box, array of ID's menu in the book.
	 */
	public int[] getPriceArray() {
		int[] box = new int[ readPrice.size() ];
		for(int i=0;i<box.length;i++) {
			box[i] = readPrice.get(i);
		}
		return box;
	}

	/**
	 * Get the amount of menu in the book.
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Reset all menu in the book.
	 */
	public void resetMenu() {
		try {
			list.clear();
			readID.clear();
			readMenu.clear();
			readPrice.clear();
			inputStream.close();
			createMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
