package genericAlgorithms;

public class NumOccurancesSortedArray {

	public static void main(String[] args) {

		int[] a = { 2, 4, 6, 10, 10, 10, 10, 18, 20, 45, 68, 70, 75, 90, 100 };
		int num = 10;
		int firstIndex = binarySearch(a, num, 0, a.length - 1, true);
		int lastIndex = binarySearch(a, num, 0, a.length - 1, false);
		System.out.println("Number to search for: " + num);
		if (firstIndex == -1 && lastIndex == -1) {
			System.out.println("Number not found");
		} else {
			System.out.println("First Index: " + firstIndex);
			System.out.println("Last Index: " + lastIndex);
			System.out.println("No. of occurances: "
					+ (lastIndex - firstIndex + 1));
		}
	}

	public static int binarySearch(int[] array, int num, int low, int high,
			boolean searchFirst) {

		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (searchFirst) {
				if (num == array[mid] && num != array[mid - 1])
					return mid;
				else if (num > array[mid]) {
					return binarySearch(array, num, mid + 1, high, searchFirst);
				}
				return binarySearch(array, num, low, mid - 1, searchFirst);
			} else {
				if (num == array[mid] && num != array[mid + 1])
					return mid;
				else if (num < array[mid]) {
					return binarySearch(array, num, low, mid - 1, searchFirst);
				}
				return binarySearch(array, num, mid + 1, high, searchFirst);
			}
		}
	}
}