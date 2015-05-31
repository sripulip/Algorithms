package genericAlgorithms;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		System.out.println("Please enter a string");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		scan.close();
		StringBuilder sb = removeDuplicates(s);
		System.out.println(sb);
	}

	private static StringBuilder removeDuplicates(String s) {
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		Iterator<Character> itr = set.iterator();
		while (itr.hasNext()) {
			sb.append(itr.next());
		}
		return sb;
	}
}
