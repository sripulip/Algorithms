package genericAlgorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Dijkstra {
	private static final Graph.Edge[] GRAPH = { new Graph.Edge(0, 1, 10),
			new Graph.Edge(0, 3, 5), new Graph.Edge(1, 2, 1),
			new Graph.Edge(1, 3, 2), new Graph.Edge(2, 4, 4),
			new Graph.Edge(3, 1, 3), new Graph.Edge(3, 2, 9),
			new Graph.Edge(3, 4, 2), new Graph.Edge(4, 0, 7),
			new Graph.Edge(4, 2, 6) };

	private static int SOURCE = 0;

	public static void main(String[] args) {
		Graph g = new Graph(GRAPH);
		g.dijkstra(SOURCE);
		g.printAllPaths();
	}
}

class Graph {
	private final Map<Integer, Vertex> graph;

	public static class Edge {
		public final int v1, v2;
		public final int dist;

		public Edge(int v1, int v2, int dist) {
			this.v1 = v1;
			this.v2 = v2;
			this.dist = dist;
		}
	}

	public static class Vertex implements Comparable<Vertex> {
		public final int name;
		public int dist = Integer.MAX_VALUE;
		public Vertex previous = null;
		public final Map<Vertex, Integer> neighbours = new HashMap<>();

		public Vertex(int name) {
			this.name = name;
		}

		private void printPath() {
			if (this == this.previous) {
				System.out.printf("%s", this.name);
			} else if (this.previous == null) {
				System.out.printf("%s(unreached)", this.name);
			} else {
				this.previous.printPath();
				System.out.printf(" -> %s(%d)", this.name, this.dist);
			}
		}

		public int compareTo(Vertex other) {
			return Integer.compare(dist, other.dist);
		}
	}

	public Graph(Edge[] edges) {
		graph = new HashMap<>(edges.length);

		for (Edge e : edges) {
			graph.put(e.v1, new Vertex(e.v1));
			graph.put(e.v2, new Vertex(e.v2));
		}

		for (Edge e : edges) {
			graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
		}
	}

	public void dijkstra(int start) {

		final Vertex source = graph.get(start);
		NavigableSet<Vertex> q = new TreeSet<>();

		for (Vertex v : graph.values()) {
			v.previous = v == source ? source : null;
			v.dist = v == source ? 0 : Integer.MAX_VALUE;
			q.add(v);
		}

		dijkstra(q);
	}

	private void dijkstra(final NavigableSet<Vertex> q) {
		Vertex u, v;
		while (!q.isEmpty()) {

			u = q.pollFirst();

			for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
				v = a.getKey();

				final int alternateDist = u.dist + a.getValue();
				if (alternateDist < v.dist) {
					q.remove(v);
					v.dist = alternateDist;
					v.previous = u;
					q.add(v);
				}
			}
		}
	}

	public void printAllPaths() {
		for (Vertex v : graph.values()) {
			v.printPath();
			System.out.println();
		}
	}
}
