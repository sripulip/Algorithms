package genericAlgorithms;

public class FindMaxNum {

	public static void main(String[] args) {
		int[] array = { 31, 41, 59, 26, 41, 58 };
		int t = 0;
		for (int j = 0; j < array.length; j++) {
			if (array[array.length - 1] < array[j]) {
				t = array[array.length - 1];
				array[array.length - 1] = array[j];
				array[j] = t;
			}
		}
		System.out.println(array[array.length - 1]);
	}
}
