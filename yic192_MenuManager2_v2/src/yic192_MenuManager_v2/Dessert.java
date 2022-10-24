package yic192_MenuManager_v2;

/**
 * Class Menu
 * author : Yida Chen
 * created: 10/23/2022
 */
public class Dessert {
    private String name;
    private String description;
    private int calories;
    public Dessert(){} // default constructor
    public Dessert(String name,String desc,int cal){ // constructor
        this.name = name;
        this.description = desc;
        this.calories = cal;
    }
    // getter and setter
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
}