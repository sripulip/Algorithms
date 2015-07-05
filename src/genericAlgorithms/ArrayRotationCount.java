package genericAlgorithms;

public class ArrayRotationCount {

	public static void main(String[] args) {
		int[] a = { 15, 22, 23, 28, 31, 38, 5, 6, 8, 10, 12 };
		// int[] a = { 1, 2, 3, 4 };
		int rotationCount = rotationCount(a, 0, a.length - 1);
		System.out.println("Array Rotation Count: " + rotationCount);
	}

	public static int rotationCount(int[] a, int low, int high) {

		if (low <= high) {

			int mid = (low + high) / 2;
			// Handling edge case: If a[mid] is the first or last element in the
			// array, a[prev] and/or a[next] need to be defined before
			// performing comparison.
			int arraySize = a.length;
			int prev = (mid - 1 + arraySize) % arraySize;
			int next = (mid + 1) % arraySize;

			if (a[low] <= a[high])
				return low;
			else if ((a[mid] <= a[prev]) && (a[mid] <= a[next]))
				return mid;
			else if (a[mid] >= a[low])
				return rotationCount(a, mid + 1, high);
			else if (a[mid] <= a[high])
				return rotationCount(a, low, mid - 1);
		}
		return -1;
	}
}
