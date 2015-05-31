package dataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class DiGraph {
	private final int V;
	private int E;
	private DoublyLinkedList<Integer>[] graphNode;

	@SuppressWarnings("unchecked")
	public DiGraph(int V) {
		this.V = V;
		graphNode = new DoublyLinkedList[V];
		for (int v = 0; v < V; v++) {
			graphNode[v] = new DoublyLinkedList<Integer>();
		}
	}

	public DiGraph(Scanner fileScanner) {
		this(fileScanner.nextInt());
		E = fileScanner.nextInt();
		for (int i = 0; i < E; i++) {
			int v1 = fileScanner.nextInt();
			int v2 = fileScanner.nextInt();
			addEdge(v1, v2);
		}
		// for (int i = 0; i < V; i++) {
		// graphNode[i].reverseDLL();
		// }
	}

	public DiGraph reverseDiGraph() {
		DiGraph rev = new DiGraph(V);
		for (int v = 0; v < V; v++) {
			Iterator<Integer> it = this.adj(v);
			while (it.hasNext()) {
				int w = it.next();
				rev.addEdge(w, v);
			}
		}
		return rev;
	}

	public void addEdge(int x, int y) {
		graphNode[x].insert(y);
	}

	public int getVertices() {
		return V;
	}

	public int getEdges() {
		return E;
	}

	public Iterator<Integer> adj(int v) {
		return graphNode[v].iterator();
	}

	public void printDiGraph() {
		for (int i = 0; i < V; i++) {
			Iterator<Integer> it = this.adj(i);
			System.out.print(i + ": ");
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileScanner = new Scanner(
				new File(
						"C:\\Users\\SRK\\Documents\\Eclipse\\Algorithms\\src\\dataStructures\\DiGraphInput1.txt"));
		DiGraph g = new DiGraph(fileScanner);
		g.printDiGraph();
		DiGraph reverse = g.reverseDiGraph();
		reverse.printDiGraph();
	}
}
