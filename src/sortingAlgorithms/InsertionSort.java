package sortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = { 31, 41, 59, 26, 41, 58 };
		int key = 0, j = 0, t = 0;
		for (int i = 0; i < a.length; i++) {
			key = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > key) {
				t = a[j];
				a[j] = a[j + 1];
				a[j + 1] = t;
				j--;
			}
			System.out.println(Arrays.toString(a));
		}
	}
}
