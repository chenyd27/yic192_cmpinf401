package yic192_MenuManager;

/**
 * Class Menu
 * author : Yida Chen
 * created: 09/29/2022
 */
public class Entree {
    private String name;
    private String description;
    private int calories;
    public Entree(){}
    public Entree(String name,String desc,int cal){ // constructor
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

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}