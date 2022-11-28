
public class Lab10Task {

	public static void main(String[] args) {
		System.out.println(sumOfDigits(234));
		int[] a = {2,3,7,8,9};
		printArrayElements(a,0);
		String x = "1234";
		printCombos(a,"",0,3);
		
	}
	// task 1
	public static int sumOfDigits(int x) {
		int ans = 0;
		while(x != 0) {
			ans += x % 10;
			x /= 10;
		}
		return ans;
	}
	// task 2
	public static void printArrayElements(int[] a,int index) {
		if(index == a.length) return;
		System.out.println(a[index]);
		printArrayElements(a,index+1);
	}
	// task 3
	public static StringBuilder str = new StringBuilder();
	public static void printCombos(int[] a, String out, int startIndex, int k) {
		if(str.length() == k) {
			out = "{" + str.toString() + "}";
			System.out.println(out);
			return;
		}
		for(int i = startIndex;i < a.length;i++) {
			str.append(a[i]);
			printCombos(a,out,i + 1,k);
			str.deleteCharAt(str.length() - 1);
		}
	}

	
}
