package genericAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import dataStructures.Graph;

public class Cycle {
	private boolean[] marked;
	private boolean hasCycle;

	public Cycle(Graph G) {
		marked = new boolean[G.getVertices()];
		for (int s = 0; s < G.getVertices(); s++)
			if (!marked[s])
				dfs(G, s, s);
	}

	private void dfs(Graph G, int v, int u) {
		marked[v] = true;
		Iterator<Integer> it = G.adj(v);
		while (it.hasNext()) {
			int w = it.next();
			if (w == u) {
				continue;
			} else if (marked[w]) {
				hasCycle = true;
				return;
			} else {
				dfs(G, w, v);
			}
		}
	}

	public boolean hasCycle() {
		return hasCycle;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(
				new File(
						"C:\\Users\\SRK\\Documents\\Eclipse\\Algorithms\\src\\dataStructures\\graphInput1.txt"));
		Graph g = new Graph(scanner);
		g.printGraph(g.getVertices());
		System.out.println();
		Cycle c = new Cycle(g);
		System.out.println(c.hasCycle());
	}
}
