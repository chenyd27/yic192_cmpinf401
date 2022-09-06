import javax.swing.JOptionPane;

public class PerimeterOfCircle {
	public static void main(String[] args) {
        final double PI = Math.PI;
        String radiusInput = JOptionPane.showInputDialog("please input radius:"); // compare to Scanner
        double radius = Double.parseDouble(radiusInput);
        double area = 2 * PI * Math.pow(radius,2);
        double perimeter = 2 * PI * radius;
        int tmpArea = (int)Math.round(area * 100);
        area = tmpArea / 100.0;
        int tmpPerimeter = (int)Math.round(perimeter * 100);
        perimeter = tmpPerimeter / 100.0;
        JOptionPane.showMessageDialog(null,"The circle with radius " + radius + " has an area of " + area + " and a perimeter of " + perimeter);
    }
}
