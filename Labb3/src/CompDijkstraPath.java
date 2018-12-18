import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CompDijkstraPath<E extends BusEdge> {

    int fromNode=0;
    int toNode;
    LinkedList<E> busEdges;

    PriorityQueue<dijsktraNode> PQ = null;

    public CompDijkstraPath(int from, int to, LinkedList<E> busEdges) {
        fromNode = from;
        toNode = to;
        this.busEdges = busEdges;
        PQ=new PriorityQueue<>();
    }

    public class dijsktraNode implements Comparable {
        public int nodeObject;
        public int from;
        public double cost;
        public Edge edge;
        public boolean visited = false;
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

        //Addar startnod
        PQ.add(new dijsktraNode(fromNode, 0, new LinkedList<BusEdge>()));
        dijsktraNode DN=null;
        while (!PQ.isEmpty()) {
            DN = PQ.poll();
            DN.checkConnectedNodes();
            if (!DN.visited) {
                if (DN.nodeObject == toNode)
                    return DN.path.iterator();
                else {
                    DN.visited = true;
                    for (dijsktraNode d : DN.connectedEdges) {
                        if (!d.visited) {
                            PQ.add(d);
                        }
                    }
                }
            }
        }
        return null;
    }


}
