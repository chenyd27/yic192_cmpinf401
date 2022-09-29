package yic192_MenuManager;

/**
 * Class Menu
 * author : Yida Chen
 * created: 09/29/2022
 */
public class Side {
    private String name;
    private String description;
    private int calories;
    public Side(){} // default constructor
    public Side(String name,String desc,int cal){   // constructor
        this.name = name;
        this.description = desc;
        this.calories = cal;
    }
    // setter and getter
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

