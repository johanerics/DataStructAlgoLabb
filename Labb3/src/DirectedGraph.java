import java.util.*;

public class DirectedGraph<E extends Edge> {

	private LinkedList<E> edges;
	private int noOfNodes;
	public List<E>[] neighbours;

	public DirectedGraph(int noOfNodes) {
		this.edges = new LinkedList<E>();
		this.noOfNodes = noOfNodes;
		neighbours = new List[noOfNodes];
		for(int i =0; i< noOfNodes;i++)
		{
			neighbours[i]= new ArrayList<>();
		}
	}

	public void addEdge(E e) {
		edges.add(e);
		neighbours[e.from].add(e);
	}

	public Iterator<E> shortestPath(int from, int to) {
		PriorityQueue<CompDijkstraPath> PQ = new PriorityQueue<>();
		ArrayList<Integer> visited = new ArrayList<>();
		CompDijkstraPath startNode = new CompDijkstraPath(from, 0,new LinkedList<BusEdge>());
		PQ.add(startNode);

		while (!PQ.isEmpty())
		{
			CompDijkstraPath node = PQ.poll();
			if (!visited.contains(node))
			{
				if(node.nodeObject==to){
					visited.clear();
					return node.path.iterator();
				}
				else {
					visited.add(node.nodeObject);
					List<E> neighboursList = neighbours[node.nodeObject];
					for (E e:neighboursList) {
						if(!visited.contains(e.to))
						{
							LinkedList<BusEdge> tempPath = new LinkedList<>();
							for (Object q:node.path) {
								tempPath.add((BusEdge)q);
							}
							CompDijkstraPath newNode = new CompDijkstraPath(e.to,node.cost+e.getWeight(),tempPath);
							newNode.path.add(e);
							PQ.add(newNode);
						}

					}
				}
			}

		}



		return null;
	}

	public Iterator<E> minimumSpanningTree() {
		CompKruskalEdge kruskal = new CompKruskalEdge(edges, noOfNodes);
		return kruskal.getMST();

	}

}