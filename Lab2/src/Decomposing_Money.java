import javax.swing.JOptionPane;

public class Decomposing_Money {
	public static void main(String[] args) {
        String numberInput = JOptionPane.showInputDialog("please input a Integer number from 1 to 9999:");
        int number = Integer.parseInt(numberInput);
        int buck = number % 10;
        number /= 10;
        int sawbucks = number % 10;
        number /= 10;
        int Benjamins = number % 10;
        number /= 10;
        int grands = number % 10;
        JOptionPane.showMessageDialog(null,grands + " grands\n" + Benjamins + " Benjamins\n" + sawbucks + " sawbucks\n" + buck + " bucks\n");
    }
}
