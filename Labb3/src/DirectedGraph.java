import java.util.*;

public class DirectedGraph<E extends Edge> {

	private LinkedList<E> edges;
	private int noOfNodes;
	public List<E>[] neighbours;

	public DirectedGraph(int noOfNodes) {
		this.edges = new LinkedList<E>();
		this.noOfNodes = noOfNodes;
		neighbours = new List[noOfNodes];
		for(int i =0; i< noOfNodes-1;i++)
		{
			neighbours[i]= new ArrayList<>();
		}
	}

	public void addEdge(E e) {
		edges.add(e);
//		neighbours[e.from].add(e);
	}

	public Iterator<E> shortestPath(int from, int to) {
		CompDijkstraPath cdp = new CompDijkstraPath(from,to, edges, neighbours);
		return cdp.getDijkstra();
	}

	public Iterator<E> minimumSpanningTree() {
		CompKruskalEdge kruskal = new CompKruskalEdge(edges, noOfNodes);
		return kruskal.getMST();
		
	}

}