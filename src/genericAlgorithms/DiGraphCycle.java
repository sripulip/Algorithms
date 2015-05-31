package genericAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import dataStructures.DiGraph;

public class DiGraphCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private boolean hasCycle;
	private boolean[] onStack;
	private Stack<Integer> stack;

	public DiGraphCycle(DiGraph G) {
		marked = new boolean[G.getVertices()];
		edgeTo = new int[G.getVertices()];
		onStack = new boolean[G.getVertices()];
		stack = new Stack<Integer>();
		for (int s = 0; s < G.getVertices(); s++) {
			if (!marked[s])
				dfs(G, s);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void dfs(DiGraph g, int v) {
		onStack[v] = true;
		marked[v] = true;
		Iterator<Integer> it = g.adj(v);
		while (it.hasNext() && !hasCycle) {
			int w = it.next();
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			} else if (onStack[w]) {
				hasCycle = true;
				for (int i = v; i != w; i = edgeTo[i]) {
					stack.push(i);
				}
				stack.push(w);
				stack.push(v);
			}

		}
		onStack[v] = false;
	}

	public boolean hasCycle() {
		return hasCycle;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(
				new File(
						"C:\\Users\\SRK\\Documents\\Eclipse\\Algorithms\\src\\dataStructures\\diGraphInput1.txt"));
		DiGraph g = new DiGraph(scanner);
		g.printDiGraph();
		System.out.println();
		DiGraphCycle c = new DiGraphCycle(g);
		System.out.println(c.hasCycle());
	}
}
