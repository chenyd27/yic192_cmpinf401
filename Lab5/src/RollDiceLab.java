import javax.swing.*;
import java.util.Random;

public class RollDiceLab {
    public static void main(String[] args) {
        Random random = new Random();
        boolean flag = true;
        while (flag){
            String input = JOptionPane.showInputDialog("please input the times of rolls");
            int times = Integer.parseInt(input);
            RollDice(times,random);
            String ifContinue = JOptionPane.showInputDialog("Press 1 and then enter if you want to continue");
            int cont = Integer.parseInt(ifContinue);
            if(cont == 1) continue;
            else flag = false;
        }
        System.out.println("Process end.");
    }
    public static void RollDice(int time, Random ran){
        int[] timeCollection = new int[13];
        double[] probabilistic = new double[]{0,0,1.0/36,2.0/36,3.0/36,4.0/36,5.0/36,6.0/36,5.0/36,4.0/36,3.0/36,2.0/36,1.0/36};
        for(int i = 0;i < time;i++){
            int dice1 = ran.nextInt(6) + 1;
            int dice2 = ran.nextInt(6) + 1;
            timeCollection[dice2 + dice1] += 1;
        }
        for(int i = 2;i <= 12;i++){
            double frac = timeCollection[i] * 1.0 / time;
            System.out.println("Value " + i + " appear " + timeCollection[i] + " times. And its fraction is: " + frac);
            System.out.println("the ideal fraction of Value " + i  + " is: " + probabilistic[i]);
        }
        System.out.println();
    }
}
