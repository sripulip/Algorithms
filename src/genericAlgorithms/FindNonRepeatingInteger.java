package genericAlgorithms;

public class FindNonRepeatingInteger {

	public static void main(String[] args) {
		int[] a = { 3, 2, 5, 2, 1, 5, 3 };
		int num = 0;
		for (int i = 0; i < a.length; i++) {
			num = num ^ a[i];
		}
		System.out.println(num);
	}
}
