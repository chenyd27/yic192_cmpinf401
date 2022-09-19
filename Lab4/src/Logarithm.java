
import javax.swing.*;

public class Logarithm {
    public static void main(String[] args) {
        String inputBase = JOptionPane.showInputDialog("Please input the base number: ");
        int base = Integer.parseInt(inputBase);
        while(base <= 1){
            inputBase = JOptionPane.showInputDialog("Wrong number, please input another base number: ");
            base = Integer.parseInt(inputBase);
        }
        System.out.println("Successful create the base number");
        String inputLog = JOptionPane.showInputDialog("Please input the number you want to calculate: ");
        int log = Integer.parseInt(inputLog);
        while(log == 0){
            inputLog = JOptionPane.showInputDialog("Wrong number, please input another number you want to calculate: ");
            log = Integer.parseInt(inputLog);
        }
        System.out.println("Successful create the number for calculating");
        int ans = getLog(base,log);
        System.out.println(ans);
    }
    public static int getLog(int base,int log){ // function to calculate the Logarithm
        int index = 0;
        while(log >= base){
            log /= base;
            index++;
        }
        return index;
    }
}
