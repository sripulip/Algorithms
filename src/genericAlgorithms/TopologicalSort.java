package genericAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import dataStructures.DiGraph;

public class TopologicalSort {

	private int V;
	private boolean[] marker;
	private Stack<Integer> stack;

	public TopologicalSort(DiGraph g) {
		this.V = g.getVertices();
		marker = new boolean[V];
		stack = new Stack<Integer>();
		for (int v = 0; v < V; v++) {
			if (!marker[v])
				depthFirstSearch(g, v);
		}
	}

	private void depthFirstSearch(DiGraph g, int s) {
		if (marker[s] == true)
			return;
		marker[s] = true;
		Iterator<Integer> it = g.adj(s);
		while (it.hasNext()) {
			int a = it.next();
			depthFirstSearch(g, a);
		}
		stack.push(s);
	}

	public Stack<Integer> getTopoSort() {
		return stack;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(
				new File(
						"C:\\Users\\SRK\\Documents\\Eclipse\\Algorithms\\src\\dataStructures\\digraphInput2.txt"));
		DiGraph g = new DiGraph(fileScanner);
		g.printDiGraph();
		TopologicalSort topo = new TopologicalSort(g);
		Stack<Integer> stack = topo.getTopoSort();
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
