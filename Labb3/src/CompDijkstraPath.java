import java.util.*;

public class CompDijkstraPath<E extends BusEdge> {

    int fromNode=0;
    int toNode;
    LinkedList<E> busEdges;


    public CompDijkstraPath(int from, int to, LinkedList<E> busEdges) {
        fromNode = from;
        toNode = to;
        this.busEdges = busEdges;

    }

    public class dijsktraNode implements Comparable {
        public int nodeObject;
        public double cost;


        public LinkedList<BusEdge> path;

        public LinkedList<dijsktraNode> connectedEdges;

        public dijsktraNode(int n, double cost, LinkedList<BusEdge> path) {
            this.nodeObject = n;
            this.cost = cost;
            this.path = path;
            connectedEdges = new LinkedList<>();
            
        }


        public void checkConnectedNodes()
        {
            for (E e : busEdges) {
                if (e.from == nodeObject) {
                    LinkedList<BusEdge> tempPath = this.path;
                    tempPath.add(e);
                    this.connectedEdges.add(new dijsktraNode(e.to, this.cost + e.getWeight(), tempPath));
                }
            }
        }

        @Override
        public int compareTo(Object o) {
            dijsktraNode dNtemp = (dijsktraNode) o;

            if (dNtemp.cost < this.cost)
                return 1;
            else if (dNtemp.cost == this.cost)
                return 0;
            else
                return -1;

        }
    }

    public Iterator<BusEdge> getDijkstra(){//LinkedList<E> edges, int fromNode, int toNode) {
        //this.fromNode = fromNode;
        //this.toNode = toNode;
        //this.busEdges = edges;
        PriorityQueue<dijsktraNode> PQ = new PriorityQueue<>();

        ArrayList<Integer> visited = new ArrayList<>();

        //Addar startnod
        PQ.add(new dijsktraNode(fromNode, 0, new LinkedList<BusEdge>()));
        dijsktraNode DN=null;
        while (!PQ.isEmpty()) {
            DN = PQ.poll();
           // DN.checkConnectedNodes();
            if (!visited.contains(DN.nodeObject)) {
                if (DN.nodeObject == toNode)
                    return DN.path.iterator();
                else {
                    visited.add(DN.nodeObject);
                    for (dijsktraNode d : DN.connectedEdges) {
                        if (!visited.contains(d)) {
                            PQ.add(d);
                        }
                    }
                }
            }
        }
        return null;
    }


}
