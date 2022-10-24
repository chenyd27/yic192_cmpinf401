package yic192_MenuManager_v2;

/**
 * Class Menu
 * author : Yida Chen
 * created: 09/29/2022
 */
public class MenuTest {
    public static void main(String[] args) {
        Entree entree1 = new Entree("Sirloin Steak","A delicious piece of 1/2 a pound of our carefully selected meat grilled and seasoned.",20);
        Entree entree2 = new Entree("Beef","Delicious",100);
        Side side = new Side("Rice","indian rice",30);
        Salad salad1 = new Salad("Cabbage","fresh",10);
        Salad salad2 = new Salad("Broccoli","Keep fit", 5);
        Dessert dessert = new Dessert("Ice cream","Coconut",150);
        Menu menu1 = new Menu("combo 1",entree1,salad1);
        Menu menu2 = new Menu("combo 2",entree2,side,salad2,dessert);
        System.out.println("Total calories of combo 1 is " + menu1.totalCalories());
        System.out.println(menu1.description());
        System.out.println("Total calories of combo 1 is " + menu2.totalCalories());
        System.out.println(menu2.description());
    }
}
