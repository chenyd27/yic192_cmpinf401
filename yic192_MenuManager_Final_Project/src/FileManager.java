
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	/**
	 * 
	 * Read MenuItem file to get an ArrayList of MenuItem
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<MenuItem> readItems(String file) throws IOException {
		FileReader fileReader = new FileReader(file); // open a fileReader stream
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<MenuItem> menuItems = new ArrayList<>();
		String line = "";
		while((line = bufferedReader.readLine()) != null){
			String[] lineSplit = line.split("@@");
			if(lineSplit.length != 5) break;
			double price = Double.parseDouble(lineSplit[4]);
			int calories = Integer.parseInt(lineSplit[3]);
			MenuItem menuItem;
			if(lineSplit[1].equals("entree")){
				 menuItem = new Entree(lineSplit[0],lineSplit[2],calories,price);
			}
			else if(lineSplit[1].equals("side")){
				 menuItem = new Side(lineSplit[0],lineSplit[2],calories,price);
			}
			else if(lineSplit[1].equals("salad")){
				 menuItem = new Salad(lineSplit[0],lineSplit[2],calories,price);
			}
			else{
				 menuItem = new Dessert(lineSplit[0],lineSplit[2],calories,price);
			}
			menuItems.add(menuItem);
		}
		bufferedReader.close();
		fileReader.close();
		return menuItems;
	}
	public static void writeMenus( String fileName, List<Menu> menus ) throws IOException{
		FileWriter fileWriter = new FileWriter(fileName);
		for(Menu menu : menus){
			String data = menu.toString() + "\n" + menu.description() + menu.priceAndCalories(menu.totalPrice(),menu.totalCalories());
			fileWriter.append(data);
			fileWriter.append("\n");
		}
		fileWriter.close();
	}
}
