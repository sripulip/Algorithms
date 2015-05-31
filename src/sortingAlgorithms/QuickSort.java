package sortingAlgorithms;

import java.util.Arrays;

class QuickSort {

	public static void main(String[] args) {

		int[] a = { 17, 12, 6, 19, 23, 8, 5, 10 };
		System.out.println("Input Array: " + Arrays.toString(a));
		quickSort(a, 0, a.length - 1);
		System.out.println("\nSorted Array: " + Arrays.toString(a));

	}

	public static void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q);
			quickSort(a, q + 1, r);
		}
	}

	public static int partition(int[] a, int p, int r) {
		int i = p;
		int j = r;
		int pivot = a[j];

		while (i <= j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
				j--;
			}
		}
		return j;
	}
}