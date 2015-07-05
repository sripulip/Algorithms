package genericAlgorithms;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		MSS();
		kadaneAlgorithm();
	}

	public static void MSS() {
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];
				ans = (sum > ans) ? sum : ans;
			}
		}
		System.out.println(ans);
	}

	public static void kadaneAlgorithm() {
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int ans = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < a.length; i++) {
			if (sum + a[i] > 0) {
				sum += a[i];
			} else {
				sum = 0;
			}
			ans = (sum > ans) ? sum : ans;
		}
		System.out.print(ans);
	}
}
