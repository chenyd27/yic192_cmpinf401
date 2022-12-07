/**
 * Class MenuTester
 * author : Yida Chen
 * created: 11/23/2022
 */

public class MenuTester {
    public static void main(String[] args) throws Exception{
        MenuManager menuManager = new MenuManager("data/dishes.txt");
        Menu myMenu = menuManager.randomMenu("test");
        Menu myMenuMin = menuManager.minCaloriesMenu("minTest");
        Menu myMenuMax = menuManager.maxCaloriesMenu("minTest");
        System.out.println(myMenu.description()+"\nTotal calories\t"+ myMenu.totalCalories());
        System.out.println(myMenuMin.description()+"\nTotal calories\t"+ myMenuMin.totalCalories());
        System.out.println(myMenuMax.description()+"\nTotal calories\t"+ myMenuMax.totalCalories());

    }
}