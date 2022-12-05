
/**
 * Class MenuItem
 * author : Yida Chen
 * created: 11/23/2022
 */


public class MenuItem extends Object {
    private String name;
    private String description;
    private int calories;
    private double price;
    public MenuItem(){};
    public MenuItem(String name,String description,int calories,double price){
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + '\n' + description + '\n' + "Calories: " + calories + '\t' + "Price: " + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
