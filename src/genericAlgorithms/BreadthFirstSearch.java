package genericAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

import dataStructures.Graph;

public class BreadthFirstSearch {

	private boolean[] marker;
	private int[] edgeTo;
	private PriorityQueue<Integer> queue;

	public BreadthFirstSearch(Graph g) {
		marker = new boolean[g.getVertices()];
		edgeTo = new int[g.getVertices()];
	}

	public Stack<Integer> findPath(Graph g, int s, int d) {
		breadthFirstSearch(g, s);
		if (!hasPathTo(d))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int i = d; i != s; i = edgeTo[i]) {
			path.add(i);
		}
		path.add(s);
		return path;
	}

	private void breadthFirstSearch(Graph g, int s) {
		queue = new PriorityQueue<Integer>();
		marker[s] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			int V = queue.poll();
			Iterator<Integer> adjacencyIterator = g.adj(V);
			while (adjacencyIterator.hasNext()) {
				int v = adjacencyIterator.next();
				if (marker[v] == false) {
					queue.add(v);
					edgeTo[v] = V;
					marker[v] = true;
				}
			}
		}
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

		BreadthFirstSearch bfs = new BreadthFirstSearch(g);
		Stack<Integer> path = bfs.findPath(g, source, destination);
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
