package genericAlgorithms;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println(fibonacciDP(50));
		System.out.println(fibonacciRecursion(50));
	}

	static double[] fibArray = new double[1001];

	public static double fibonacciDP(int n) {

		if (n <= 2) {
			return 1;
		} else {
			if (fibArray[n] != 0) {
				return fibArray[n];
			} else {
				fibArray[n] = fibonacciDP(n - 1) + fibonacciDP(n - 2);
				return fibArray[n];
			}
		}
	}

	public static double fibonacciRecursion(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
		}
	}

}
