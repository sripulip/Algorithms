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

		int[] a = { 2, 4, 6, 10, 10, 18, 20, 45, 68, 70, 75, 90, 100 };
		System.out.println("Index: " + binarySearch(a, 10, 0, a.length - 1));
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

	public static int binarySearch(int[] array, int num, int low, int high) {

		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (num == array[mid])
				return mid;
			else if (num < array[mid]) {
				return binarySearch(array, num, low, mid - 1);
			}
			return binarySearch(array, num, mid + 1, high);
		}
	}
}