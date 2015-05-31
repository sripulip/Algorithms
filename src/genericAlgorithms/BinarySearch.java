package genericAlgorithms;

import java.util.Scanner;

class BinarySearch {
	public static void main(String[] args) {
		System.out.println("Please input a number");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();
		int output = binarySearch(input);
		if (output == -1) {
			System.out.println("Element not found!!");
		} else {
			System.out.println("Element " + input + " is positioned at "
					+ output);
		}
	}

	public static int binarySearch(int input) {
		int[] a = { 1, 3, 5, 7, 8, 9, 11, 14, 16, 17, 18, 19, 20, 22, 24 };
		int low = 0, high = a.length - 1;
		do {
			int mid = (low + high) / 2;
			if (input < a[mid]) {
				high = mid - 1;
			} else if (input > a[mid]) {
				low = mid + 1;
			} else
				return mid + 1;
		} while (low <= high);
		return -1;
	}
}