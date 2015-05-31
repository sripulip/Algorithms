package sortingAlgorithms;

import java.util.Arrays;

public class HeapSort {
	private static int N;

	public static void sort(int arr[]) {
		maxHeapify(arr);
		for (int i = N; i > 0; i--) {
			swap(arr, 0, i);
			N = N - 1;
			buildMaxHeap(arr, 0);
		}
	}

	/* Function to build a heap */
	public static void maxHeapify(int arr[]) {
		N = arr.length - 1;
		for (int i = N / 2; i >= 0; i--) {
			buildMaxHeap(arr, i);
		}
	}

	/* Function to swap largest element in heap */
	public static void buildMaxHeap(int arr[], int i) {
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		int max = i;
		if (left <= N && arr[left] > arr[i]) {
			max = left;
		}
		if (right <= N && arr[right] > arr[max]) {
			max = right;
		}
		if (max != i) {
			swap(arr, i, max);
			buildMaxHeap(arr, max);
		}
	}

	/* Function to swap two numbers in an array */
	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/* Main method */
	public static void main(String[] args) {
		int arr[] = { 15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1 };
		System.out.println(Arrays.toString(arr) + "\n");
		sort(arr);
		System.out.println("\n" + Arrays.toString(arr));
	}
}