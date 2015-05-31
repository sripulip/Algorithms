package genericAlgorithms;

import java.util.Scanner;

public class FloydWarshall {

	public static void main(String[] args) {

		// Declare and Initialize Adjacency and Path Matrices.
		int[][] adjMatrix = data();
		int[][] pathMatrix = new int[6][6];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (adjMatrix[i][j] == 100)
					pathMatrix[i][j] = Integer.MAX_VALUE;
				else
					pathMatrix[i][j] = i;
			}
			pathMatrix[i][i] = 0;
		}

		// Call Floyd Warshall Algorithm
		int[][] distanceMatrix = floydWarshall(adjMatrix, pathMatrix);

		// Print the distance matrix
		System.out.println("Distance matrix\n");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++)
				System.out.print(distanceMatrix[i][j] + "\t");
			System.out.println();
		}

		// Take input from the user -> Source and Destination vertices
		Scanner stdin = new Scanner(System.in);
		System.out.println("\nEnter source and destination");
		int start = stdin.nextInt();
		int end = stdin.nextInt();

		// Print the path from source to destination and its length
		String path = end + "";
		int updatedEnd = end;

		while (pathMatrix[start][updatedEnd] != start) {
			path = pathMatrix[start][updatedEnd] + " -> " + path;
			updatedEnd = pathMatrix[start][updatedEnd];
		}
		path = start + " -> " + path;
		System.out.println("\nShortest Path: " + path);
		System.out.println("Path Length: " + distanceMatrix[start][end]);
		stdin.close();
	}

	// Floyd Warshall Algorithm to compute and return all pairs shortest
	// path matrix
	// Considers every possible path at each iteration. Hence 3 'for' loops
	public static int[][] floydWarshall(int[][] adjMatrix, int[][] pathMatrix) {

		for (int k = 0; k < adjMatrix.length; k++) {
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix.length; j++) {
					if (adjMatrix[i][k] + adjMatrix[k][j] < adjMatrix[i][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						pathMatrix[i][j] = pathMatrix[k][j];
					}
				}
			}
		}
		return adjMatrix;
	}

	public static int[][] data() {
		int[][] adj = new int[6][6];
		adj[0][0] = 0;
		adj[0][1] = 1;
		adj[0][2] = 100;
		adj[0][3] = 2;
		adj[0][4] = 100;
		adj[0][5] = 100;
		adj[1][0] = 100;
		adj[1][1] = 0;
		adj[1][2] = 4;
		adj[1][3] = 100;
		adj[1][4] = 100;
		adj[1][5] = 100;
		adj[2][0] = 100;
		adj[2][1] = 100;
		adj[2][2] = 0;
		adj[2][3] = 100;
		adj[2][4] = 100;
		adj[2][5] = 3;
		adj[3][0] = 100;
		adj[3][1] = 100;
		adj[3][2] = 2;
		adj[3][3] = 0;
		adj[3][4] = 3;
		adj[3][5] = 100;
		adj[4][0] = 100;
		adj[4][1] = 4;
		adj[4][2] = 3;
		adj[4][3] = 100;
		adj[4][4] = 0;
		adj[4][5] = 100;
		adj[5][0] = 3;
		adj[5][1] = 100;
		adj[5][2] = 100;
		adj[5][3] = 100;
		adj[5][4] = 1;
		adj[5][5] = 0;
		return adj;
	}
}