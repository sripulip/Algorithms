package genericAlgorithms;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String lcs = lcs("baced", "abcd");
		System.out.println(lcs);
	}

	public static String lcs(String a, String b) {
		int[][] matrix = new int[a.length() + 1][b.length() + 1];

		// find LCS
		for (int i = 0; i < a.length(); i++)
			for (int j = 0; j < b.length(); j++)
				if (a.charAt(i) == b.charAt(j))
					matrix[i + 1][j + 1] = matrix[i][j] + 1;
				else
					matrix[i + 1][j + 1] = Math.max(matrix[i + 1][j],
							matrix[i][j + 1]);

		// Print Answer
		StringBuffer sb = new StringBuffer();
		for (int x = a.length(), y = b.length(); x != 0 && y != 0;) {
			System.out.println("x:" + x + " y:" + y + " " + sb.toString());
			if (matrix[x][y] == matrix[x - 1][y])
				x--;
			else if (matrix[x][y] == matrix[x][y - 1])
				y--;
			else {
				sb.append(a.charAt(x - 1));
				x--;
				y--;
			}
		}
		System.out.println();
		return sb.reverse().toString();
	}
}
