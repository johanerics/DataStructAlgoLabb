import java.util.*;

public class DirectedGraph<E extends Edge> {

	private LinkedList<E> edges;
	private int noOfNodes;
	public List<E>[] neighbours;

	public DirectedGraph(int noOfNodes) {
		this.edges = new LinkedList<E>();
		this.noOfNodes = noOfNodes;
	}

	public void addEdge(E e) {
		edges.add(e);
		neighbours[e.from].add(e);
	}

	public Iterator<E> shortestPath(int from, int to) {
		CompDijkstraPath cdp = new CompDijkstraPath(from,to, edges);
		return cdp.getDijkstra();
	}

	public Iterator<E> minimumSpanningTree() {
		//CompKruskalEdge kruskal = new CompKruskalEdge(edges, noOfNodes);
		//return kruskal.getMST();
		return null;
	}

}