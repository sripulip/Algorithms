package genericAlgorithms;

import java.util.Scanner;

public class FirstRepetitionOfCharacter {

	public static void main(String[] args) {
		System.out.println("Please enter a string");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		System.out.println("Please enter a character");
		char c = scan.next().charAt(0);
		scan.close();
		firstRepetition(s, c);
	}

	private static void firstRepetition(String s, char c) {
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				if (count == 1) {
					System.out.println("Repition found at position " + (i + 1));
					flag = true;
					break;
				}
				count++;
			}
		}
		if (!flag) {
			System.out
					.println("No repetitions found for the entered character");
		}
	}
}
