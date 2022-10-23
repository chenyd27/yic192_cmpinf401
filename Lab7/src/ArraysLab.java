import javax.swing.*;

public class ArraysLab {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Please input the size of array you want to create:");
        int size = Integer.parseInt(input);
        double[] data = new double[size]; // initialize array
        for(int i = 0;i < size;i++){
            data[i] = Math.random() * 10; // generate values randomly
        }
        // output the results
        System.out.println(max(data));
        System.out.println(min(data));
        System.out.println(sum(data));
        System.out.println(ave(data));
    }
	public static double max(double[] data) {
		double tmp = Double.MIN_VALUE;
		for(int i = 0;i < data.length;i++) {
			tmp = Math.max(tmp, data[i]);
		}
		return tmp;
	}
	public static double min(double[] data) {
		double tmp = Double.MAX_VALUE;
		for(int i = 0;i < data.length;i++) {
			tmp = Math.min(tmp, data[i]);
		}
		return tmp;
	}
	public static double sum(double[] data) {
		double sum =0;
		for(int i = 0;i < data.length;i++) {
			sum += data[i];
		}
		return sum;
	}
	public static double ave(double[] data) {
		double sum = sum(data);
		double avg = sum / data.length;
		return avg;
	}
	
}
