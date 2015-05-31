package genericAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import dataStructures.Graph;

public class DepthFirstSearch {
	private boolean[] marker;
	private int[] edgeTo;
	private int count;

	public DepthFirstSearch(Graph g) {
		marker = new boolean[g.getVertices()];
		edgeTo = new int[g.getVertices()];
	}

	public boolean DFSGraphConnectivity(Graph g, int s) {
		depthFirstSearch(g, s);
		return count == g.getVertices();
	}

	public Stack<Integer> findPath(Graph g, int s, int d) {
		depthFirstSearch(g, s);
		if (!hasPathTo(d))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = d; x != s; x = edgeTo[x])
			path.add(x);
		path.add(s);
		return path;
	}

	private void depthFirstSearch(Graph g, int s) {
		if (marker[s] == true)
			return;
		marker[s] = true;
		Iterator<Integer> it = g.adj(s);
		while (it.hasNext()) {
			int a = it.next();
			if (!marker[a]) {
				edgeTo[a] = s;
			}
			depthFirstSearch(g, a);
		}
		count++;
	}

	private boolean hasPathTo(int d) {
		return marker[d];
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(
				new File(
						"C:\\Users\\SRK\\Documents\\Eclipse\\Algorithms\\src\\dataStructures\\graphInput2.txt"));
		Graph g = new Graph(scanner);
		g.printGraph(g.getVertices());
		scanner = new Scanner(System.in);
		System.out.println("Enter source vertex");
		int source = scanner.nextInt();
		System.out.println("Enter destination vertex");
		int destination = scanner.nextInt();
		scanner.close();

		DepthFirstSearch dfs = new DepthFirstSearch(g);
		Stack<Integer> path = dfs.findPath(g, source, destination);
		if (path != null) {
			while (!path.isEmpty()) {
				System.out.print(" - ");
				System.out.print(path.pop());
			}
		} else {
			System.out.println("Vertices not connected");
		}
	}
}