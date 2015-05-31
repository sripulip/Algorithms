package sortingAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class BucketSort {

	public static void main(String[] args) {
		System.out.println("Enter 'n'");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		// Declare an array
		double[] a = new double[n];
		// Fill the array with random values between 0 & 1
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			a[i] = rand.nextDouble();
		}
		System.out.println("Input Array: " + Arrays.toString(a));
		// Call bucketSort function
		LinkedList<Double>[] arrayList = bucketSort(a, n);
		// Print the sorted array
		printSortedArray(arrayList, n);
	}

	public static LinkedList<Double>[] bucketSort(double[] a, int n) {
		// Create an array of Linked Lists
		@SuppressWarnings("unchecked")
		LinkedList<Double>[] list = new LinkedList[n];
		// Initialize the linked lists
		for (int k = 0; k < n; k++) {
			list[k] = new LinkedList<Double>();
		}
		// Fill the linked list with elements in sorted order
		for (int i = 0; i < n; i++) {
			// Calculate the hash index for every element
			int arrayIndex = (int) (a[i] * n);
			int j = 0;
			int y = list[arrayIndex].size();
			boolean flag = false;

			// Linked list chaining for elements which map to the same bucket
			if (list[arrayIndex].size() > 0) {
				while (j < y) {
					if (list[arrayIndex].get(j) > a[i]) {
						double temp = list[arrayIndex].remove(j);
						list[arrayIndex].add(j, a[i]);
						list[arrayIndex].add(j + 1, temp);
						flag = true;
						break;
					}
					j++;
				}
				if (!flag) {
					list[arrayIndex].add(a[i]);
				}
			} else {
				// If no hash collisions, insert the elements into linked list
				list[arrayIndex].add(a[i]);
			}
		}
		return list;
	}

	public static void printSortedArray(LinkedList<Double>[] list, int n) {
		double[] b = new double[n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				b[k] = list[i].get(j);
				k++;
			}
		}
		System.out.println("Sorted Array:" + Arrays.toString(b));
	}
}
