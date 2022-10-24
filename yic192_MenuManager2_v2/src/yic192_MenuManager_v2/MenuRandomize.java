package yic192_MenuManager_v2;

/**
 * Class Menu
 * author : Yida Chen
 * created: 10/23/2022
 */

import java.io.IOException;
import java.util.ArrayList;

public class MenuRandomize {
    ArrayList<Entree> entrees;
    ArrayList<Salad> salads;
    ArrayList<Side> sides;
    ArrayList<Dessert> desserts;

    /**
     * Constructor of this class
     * Initialize all ArrayLists object
     * @param entreeFile
     * @param saladFile
     * @param sideFile
     * @param dessertFile
     */
    public MenuRandomize(String entreeFile,String saladFile,String sideFile,String dessertFile){
        try{
            entrees = FileManager.readEntrees(entreeFile);
            salads = FileManager.readSalads(saladFile);
            sides = FileManager.readSides(sideFile);
            desserts = FileManager.readDesserts(dessertFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * The method randomMenu() randomly picks one Entree, one Side, one Salad and one Dessert.
     * Returns a Menu object composed of the random dishes.
     * @return
     */
    public Menu randomMenu(){
        Entree entree = entrees.get((int)(Math.random() * 100) % entrees.size());
        Salad salad = salads.get((int)(Math.random() * 100) % salads.size());
        Side side = sides.get((int)(Math.random() * 100) % sides.size());
        Dessert dessert = desserts.get((int)(Math.random() * 100) % desserts.size());
        // initialize the name of the menu
        String name = entree.getName() + "\t" + side.getName() + "\t" + salad.getName() + "\t" + dessert.getName();
        Menu menu = new Menu(name,entree,side,salad,dessert);
        return menu;
    }
}
