package dataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Graph {

	private final int V;
	private int E;
	private DoublyLinkedList<Integer>[] graphNode;

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		graphNode = new DoublyLinkedList[V];
		for (int v = 0; v < V; v++) {
			graphNode[v] = new DoublyLinkedList<Integer>();
		}
	}

	public Graph(Scanner fileScanner) {
		this(fileScanner.nextInt());
		E = fileScanner.nextInt();
		for (int i = 0; i < E; i++) {
			int v1 = fileScanner.nextInt();
			int v2 = fileScanner.nextInt();
			addEdge(v1, v2);
		}
		for (int i = 0; i < V; i++) {
			graphNode[i].reverseDLL();
		}
	}

	public void addEdge(int x, int y) {
		graphNode[x].insert(y);
		graphNode[y].insert(x);
	}

	public int getVertices() {
		return V;
	}

	public int getEdges() {
		return E;
	}

	public Iterator<Integer> adj(int V) {
		return graphNode[V].iterator();
	}

	public void printGraph(int v) {
		for (int i = 0; i < v; i++) {
			Iterator<Integer> it = this.adj(i);
			System.out.print(i + ": ");
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner fileScanner = new Scanner(
				new File(
						"C:\\Users\\SRK\\Documents\\Eclipse\\Algorithms\\src\\dataStructures\\graphInput2.txt"));
		Graph g = new Graph(fileScanner);
		g.printGraph(g.getVertices());
	}
}
