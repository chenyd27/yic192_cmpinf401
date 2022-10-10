package yic192_Lab3;
import javax.swing.*;
public class UnitConverter {
    public static String converter(String input){
        int index = 0;
        for(int i = 0;i < input.length();i++){
            if(input.charAt(i) == ' '){
                index = i;
                break;
            }
        }
        double number = Double.parseDouble(input.substring(0,index));
        String unit = input.substring(index + 1);
        String ans = "";
        // convert number
        if(unit.equals("cm")){
            unit = "in";
            number = number * 2.54;
        }else if(unit.equals("in")){
            unit = "cm";
            number /= 2.54;
        }else if(unit.equals("yd")){
            unit = "m";
            number *= 0.9144;
        }else if(unit.equals("m")){
            unit = "yd";
            number /= 0.9144;
        }else if(unit.equals("oz")){
            unit = "gm";
            number *= 28.349523125;
        }else if(unit.equals("gm")){
            unit = "oz";
            number /= 28.349523125;
        }else if(unit.equals("lb")){
            unit = "kg";
            number *= 0.45359237;
        }else if(unit.equals("kg")){
            unit = "lb";
            number /= 0.45359237;
        }else{
            return "";
        }
        ans = number + " " + unit;
        return ans;
    }
    public static void main(String[] args) {
    	// input a parameter that need to be converted
        String input = JOptionPane.showInputDialog("please input a distance you want to convert");
        String ans = converter(input);
        if(ans != ""){
            JOptionPane.showMessageDialog(null,"the converted number = " + ans);
        }else{
            JOptionPane.showMessageDialog(null,"error happened");
        }
    }
}
