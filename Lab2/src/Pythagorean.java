
import javax.swing.JOptionPane;

public class Pythagorean {
	public static void main(String[] args) {
		String numInput01 = JOptionPane.showInputDialog("please input num01:"); // compare to Scanner
        String numInput02 = JOptionPane.showInputDialog("please input num02:");
        double a = Double.parseDouble(numInput01);
        double b = Double.parseDouble(numInput02);
        double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        c = c * 100;
        int tmpC = (int)Math.round(c);
        c = tmpC / 100.0;
        JOptionPane.showMessageDialog(null,"the hypotenuse is " + c);
	}
}
