package genericAlgorithms;

public class FibonacciDP {

	public static void main(String[] args) {

		System.out.println(fibonacci(1000));
	}

	static double[] fibArray = new double[1001];

	public static double fibonacci(int n) {

		if (n <= 2) {
			return 1;
		} else {
			if (fibArray[n] != 0) {
				return fibArray[n];
			} else {
				fibArray[n] = fibonacci(n - 1) + fibonacci(n - 2);
				return fibArray[n];
			}
		}
	}

}
