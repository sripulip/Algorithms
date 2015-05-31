package genericAlgorithms;

import java.util.Scanner;

public class PrimeNumbers {

	public static boolean isPrime(int num) {
		double sqrt = Math.sqrt(num);
		for (double i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void printPrimesTillN(int num) {
		for (int i = 2; i <= num; i++) {
			boolean result = isPrime(i);
			if (result == true) {
				System.out.println(i);
			}
		}
	}

	public static void firstNPrimes(int N) {
		int count = 0;
		int i = 2;
		while (count < N) {
			boolean result = isPrime(i);
			if (result == true) {
				System.out.println(i);
				count++;
			}
			i++;
		}
	}

	public static void main(String a[]) {
		System.out.println("Please enter a number");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		// boolean result = isPrime(n);
		// System.out.println(result);
		printPrimesTillN(n);
		// firstNPrimes(n);
	}
}