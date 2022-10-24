package yic192_MenuManager_v2;

/**
 * Class Menu
 * author : Yida Chen
 * created: 10/23/2022
 */

public class MenuTester {
    public static void main(String[] args){
        MenuRandomize randomize = new MenuRandomize("data/entrees.txt",
                "data/sides.txt","data/salads.txt","data/desserts.txt");
        Menu myMenu = randomize.randomMenu();
        System.out.println(myMenu.description()+"\nTotal calories\t"+ myMenu.totalCalories());
    }
}