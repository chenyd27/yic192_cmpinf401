/**
 * Class Menu
 * author : Yida Chen
 * created: 10/23/2022
 */

public class Menu {
    private String name;
    private Entree entree;
    private Side side;
    private Salad salad;
    private Dessert dessert;
    public Menu(){}
    public Menu(String name){
        this.name = name;
        this.entree = null;
        this.side = null;
        this.salad = null;
        this.dessert = null;
    }
    public Menu(String name,Entree entree,Salad salad){ // constructor with different object
        this.name = name;
        this.entree = entree;
        this.salad = salad;
        this.side = null;
        this.dessert = null;
    }
    public Menu(String name,Entree entree,Side side){
        this.name = name;
        this.entree = entree;
        this.salad = null;
        this.side = side;
        this.dessert = null;
    }
    public Menu(String name,Entree entree,Side side,Salad salad,Dessert dessert){
        this.name = name;
        this.entree = entree;
        this.side = side;
        this.salad = salad;
        this.dessert = dessert;
    }
    public int totalCalories(){
        Entree et = getEntree(); // initialize all the objects
        Side s = getSide();
        Salad sal = getSalad();
        Dessert des = getDessert();
        int sum = 0;
        if(et != null) sum += et.getCalories(); // judge if there is the object
        if(s != null) sum += s.getCalories();
        if(sal != null) sum += sal.getCalories();
        if(des != null) sum += des.getCalories();
        return sum;
    }
    public String description(){
        Entree et = getEntree();
        Side s = getSide();
        Salad sal = getSalad();
        Dessert des = getDessert();
        String res = "";
     // judge if there is the object
        if(et != null){
            String tmp = "Entree: " + et.getName() + "\t" + et.getDescription() + ".\t" + "Calories: " +  et.getCalories() + "\tPrice:" + et.getPrice() + '\n';
            res += tmp;
        }else{
            String tmp = "Entree: N/A.\n";
            res += tmp;
        }
        if(s != null) {
            String tmp = "Side: " + s.getName() + ". " + s.getDescription() + ".\t" + "Calories: " + s.getCalories() + "\tPrice:" + s.getPrice() + '\n';
            res += tmp;
        }else{
            String tmp = "Side: N/A.\n";
            res += tmp;
        }
        if(sal != null){
            String tmp = "Salad: " + sal.getName() + ". " +sal.getDescription() + ".\t" + "Calories: " + sal.getCalories() + "\tPrice:" + sal.getPrice() + '\n';
            res += tmp;
        }else{
            String tmp = "Salad: N/A.\n";
            res += tmp;
        }
        if(des != null){
            String tmp = "Dessert: " + des.getName() + ". " + des.getDescription() + ".\t" + "Calories: " + des.getCalories() + "\t:" + des.getPrice() + '\n';
            res += tmp;
        }else{
            String tmp = "Dessert: N/A.\n";
            res += tmp;
        }
        return res;
    }
    public double totalPrice(){
        Entree et = getEntree(); // initialize all the objects
        Side s = getSide();
        Salad sal = getSalad();
        Dessert des = getDessert();
        double sum = 0;
        if(et != null) sum += et.getPrice(); // judge if there is the object
        if(s != null) sum += s.getPrice();
        if(sal != null) sum += sal.getPrice();
        if(des != null) sum += des.getPrice();
        return sum;
    }
    public String priceAndCalories(double price,int calories){
        String res = "Total calories:\t" + calories + "\n" + "Total price:\t" + price + "\n";
        return res;
    }
    
    // getter and setter
    public Entree getEntree() {
        return entree;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setEntree(Entree entree) {
        this.entree = entree;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Salad getSalad() {
        return salad;
    }

    public void setSalad(Salad salad) {
        this.salad = salad;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}