package genericAlgorithms;

import java.util.Arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
		int[] a = { 12, 15, 101, 1, 3 };
		System.out.println(Arrays.toString(a));
		reverseArray(a);
		System.out.println(Arrays.toString(a));
	}

	public static void reverseArray(int[] arr) {
		int temp = 0;
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}
}
