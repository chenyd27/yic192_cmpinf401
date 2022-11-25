import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MenuManager {
    private ArrayList<Entree> entrees = new ArrayList<>();
    private ArrayList<Side> sides = new ArrayList<>();
    private ArrayList<Salad> salads = new ArrayList<>();
    private ArrayList<Dessert> desserts = new ArrayList<>();
    public MenuManager(String dishesFile) throws IOException {
        ArrayList<MenuItem> arrayList = FileManager.readItems(dishesFile);
        for(MenuItem menuItem : arrayList){
            if(menuItem instanceof Entree){
                entrees.add((Entree) menuItem);
            }else if(menuItem instanceof Side){
                sides.add((Side) menuItem);
            }if(menuItem instanceof Salad){
                salads.add((Salad) menuItem);
            }if(menuItem instanceof Dessert){
                desserts.add((Dessert) menuItem);
            }
        }
    }

    public Menu randomMenu(String name){
        Entree entree = entrees.get((int)(Math.random() * 100) % entrees.size());
        Salad salad = salads.get((int)(Math.random() * 100) % salads.size());
        Side side = sides.get((int)(Math.random() * 100) % sides.size());
        Dessert dessert = desserts.get((int)(Math.random() * 100) % desserts.size());
        // initialize the name of the menu
        Menu menu = new Menu(name,entree,side,salad,dessert);
        return menu;
    }

    public MenuItem getTheMinItem(MenuItem[] list){
        int calories = Integer.MAX_VALUE;
        MenuItem menuItem = new MenuItem();
        for(MenuItem menu : list){
            if(menu.getCalories() < calories){
                menuItem = menu;
                calories = menu.getCalories();
            }
        }
        return menuItem;
    }
    public MenuItem getTheMaxItem(MenuItem[] arrayList){
        int calories = Integer.MIN_VALUE;
        MenuItem menuItem = new MenuItem();
        for(MenuItem menu : arrayList){
            if(menu.getCalories() > calories){
                menuItem = menu;
                calories = menu.getCalories();
            }
        }
        return menuItem;
    }
    public Menu minCaloriesMenu(String name){
        Entree[] entreelist = (Entree[]) entrees.toArray();
        Side[] sidelist = (Side[])sides.toArray();
        Salad[] saladlist = (Salad[])salads.toArray();
        Dessert[] dessertlist = (Dessert[])desserts.toArray();
        Entree entree = (Entree) getTheMinItem(entreelist);
        Side side = (Side) getTheMinItem(sidelist);
        Salad salad = (Salad) getTheMinItem(saladlist);
        Dessert dessert = (Dessert) getTheMinItem(dessertlist);
        Menu menu = new Menu(name,entree,side,salad,dessert);
        return menu;
    }
    public Menu maxCaloriesMenu(String name){
        Entree[] entreelist = (Entree[]) entrees.toArray();
        Side[] sidelist = (Side[])sides.toArray();
        Salad[] saladlist = (Salad[])salads.toArray();
        Dessert[] dessertlist = (Dessert[])desserts.toArray();
        Entree entree = (Entree) getTheMaxItem(entreelist);
        Side side = (Side) getTheMaxItem(sidelist);
        Salad salad = (Salad) getTheMaxItem(saladlist);
        Dessert dessert = (Dessert) getTheMaxItem(dessertlist);
        Menu menu = new Menu(name,entree,side,salad,dessert);
        return menu;
    }

    public ArrayList<Entree> getEntrees() {
        return entrees;
    }

    public void setEntrees(ArrayList<Entree> entrees) {
        this.entrees = entrees;
    }

    public ArrayList<Side> getSides() {
        return sides;
    }

    public void setSides(ArrayList<Side> sides) {
        this.sides = sides;
    }

    public ArrayList<Salad> getSalads() {
        return salads;
    }

    public void setSalads(ArrayList<Salad> salads) {
        this.salads = salads;
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(ArrayList<Dessert> desserts) {
        this.desserts = desserts;
    }
}
