
/**
 * Class MenuTester
 * author : Yida Chen
 * created: 11/23/2022
 */

public class MenuTester {
    public static void main(String[] args) throws Exception{
        MenuManager randomize = new MenuManager("data/dishes.txt");
        Menu myMenu = randomize.randomMenu("test");
        Menu minMenu = randomize.minCaloriesMenu("");
        System.out.println(minMenu.description());
        System.out.println(myMenu.description()+"\nTotal calories\t"+ myMenu.totalCalories());
    }
}