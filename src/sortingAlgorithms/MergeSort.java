package sortingAlgorithms;

import java.util.Arrays;

class MergeSort {

	private static int[] aux;

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		aux = new int[a.length];
		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(int[] a, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			System.out.println("mergeSort(a," + low + "," + high + ")");
			mergeSort(a, low, mid);
			System.out.println("mergeSort(a," + low + "," + high + ")");
			mergeSort(a, mid + 1, high);
			System.out.println("merge(a," + low + "," + mid + "," + high + ")");
			merge(a, low, mid, high);
		}
	}

	private static void merge(int[] a, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			aux[i] = a[i];
		}
		int i = low;
		int k = low;
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