package genericAlgorithms;

import java.util.Scanner;

public class StringReverseRecursion {

	public static void main(String[] args) {
		System.out.println("Please enter a string");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		scan.close();
		System.out.println(reverseString(s));
	}

	public static String reverseString(String s) {
		if (s.length() == 0)
			return s;
		return reverseString(s.substring(1)) + s.charAt(0);
	}
}
