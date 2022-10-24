package yic192_MenuManager_v2;

/**
 * Class Menu
 * author : Yida Chen
 * created: 10/23/2022
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	/**
	 * 
	 * Read entrees file to get an ArrayList of entree
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Entree> readEntrees(String file) throws IOException {
		FileReader fileReader = new FileReader(file); // open a fileReader stream
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Entree> entreeList = new ArrayList<>();
		String line = "";
		while((line = bufferedReader.readLine()) != null){
			String[] lineSplit = line.split("@@");
			if(lineSplit.length != 3) break;
			Entree entree = new Entree();
			entree.setName(lineSplit[0]);
			entree.setDescription(lineSplit[1]);
			entree.setCalories(Integer.parseInt(lineSplit[2]));
			entreeList.add(entree);
		}
		bufferedReader.close();
		fileReader.close();
		return entreeList;
	}
	/**
	 * Read salads file to get an ArrayList of salad
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Salad> readSalads(String file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Salad> saladsList = new ArrayList<>();
		String line = "";
		while((line = bufferedReader.readLine()) != null){
			String[] lineSplit = line.split("@@");
			if(lineSplit.length != 3) break;
			Salad salad = new Salad();
			salad.setName(lineSplit[0]);
			salad.setDescription(lineSplit[1]);
			salad.setCalories(Integer.parseInt(lineSplit[2]));
			saladsList.add(salad);
		}
		bufferedReader.close();
		fileReader.close();
		return saladsList;
	}
	/**
	 * Read sides file to get an ArrayList of side
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Side> readSides(String file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Side> sidesList = new ArrayList<>();
		String line = "";
		while((line = bufferedReader.readLine()) != null){
			String[] lineSplit = line.split("@@");
			if(lineSplit.length != 3) break;
			Side side = new Side();
			side.setName(lineSplit[0]);
			side.setDescription(lineSplit[1]);
			side.setCalories(Integer.parseInt(lineSplit[2]));
			sidesList.add(side);
		}
		bufferedReader.close();
		fileReader.close();
		return sidesList;
	}
	/**
	 * Read desserts file to get an ArrayList of dessert
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Dessert> readDesserts(String file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Dessert> dessertsList = new ArrayList<>();
		String line = "";
		while((line = bufferedReader.readLine()) != null){
			String[] lineSplit = line.split("@@"); // split the String to get parameters
			if(lineSplit.length != 3) break;
			Dessert dessert = new Dessert();
			dessert.setName(lineSplit[0]);
			dessert.setDescription(lineSplit[1]);
			dessert.setCalories(Integer.parseInt(lineSplit[2]));
			dessertsList.add(dessert); // add the dessert object into the list
		}
		bufferedReader.close();
		fileReader.close();
		return dessertsList;
	}
}
