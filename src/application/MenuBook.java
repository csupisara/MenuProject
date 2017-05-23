package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
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

	public MenuBook( String fileName ) {
		try {
			this.fileName = fileName;
			list = new ArrayList<Menu>();
			readID = new ArrayList<Integer>();
			readMenu = new ArrayList<String>();
			readPrice = new ArrayList<Integer>();
			createMenu( fileName );	
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

	private void createMenu(String inputFileName) {
		try {
			inputStream = new FileInputStream( inputFileName );
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

	public ArrayList<Menu> getAllMenuList() {
		return list;
	}

	public int[] getIDArray() {
		int[] box = new int[ readID.size() ];
		for(int i=0;i<box.length;i++) {
			box[i] = readID.get(i);
		}
		return box;
	}

	public String[] getMenuArray() {
		String[] box = new String[ readMenu.size() ];
		for(int i=0;i<box.length;i++) {
			box[i] = readMenu.get(i);
		}
		return box;
	}

	public int[] getPriceArray() {
		int[] box = new int[ readPrice.size() ];
		for(int i=0;i<box.length;i++) {
			box[i] = readPrice.get(i);
		}
		return box;
	}

	public int getCapacity() {
		return capacity;
	}

	public void resetMenu() {
		list.clear();
		readID.clear();
		readMenu.clear();
		readPrice.clear();
		createMenu( fileName );
	}

}
