package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
	static int[] aux;

	public static void main(String[] args) {
		int[] arr = { 16, 24, 17, 2, 4, 12, 20, 100 };
		// char[] arr = { 'E', 'E', 'G', 'M', 'R', 'A', 'C', 'E', 'R', 'T' };
		System.out.println("Input: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("\nOutput:" + Arrays.toString(arr));
	}

	public static void sort(int[] a) {
		aux = new int[a.length];
		mergesort(a, 0, a.length - 1);
	}

	private static void mergesort(int[] a, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergesort(a, low, mid);
			mergesort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}

	private static void merge(int[] a, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			aux[i] = a[i];
		}
		int i = low, k = low;
		int j = mid + 1;
		while (i <= mid && j <= high) {
			if (aux[i] <= aux[j]) {
				a[k] = aux[i];
				i++;
				k++;
			} else {
				a[k] = aux[j];
				j++;
				k++;
			}
		}

		while (i <= mid) {
			a[k] = aux[i];
			i++;
			k++;
		}

	}
}