import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CompDijkstraPath <E extends Edge>{

    int fromNode;
    int toNode;
    LinkedList<E> busEdges;

    PriorityQueue<dijsktraNode> PQ = null;

    public class dijsktraNode
    {
        public int nodeObject;
        public int from;
        public double cost;
        public Edge edge;
        public boolean visited = false;
        public int[] path;
        public List<dijsktraNode> connectedEdges;

        public dijsktraNode(int n, double cost, Edge edge)
        {
            this.nodeObject = n;
            this.cost = cost;
            this.edge = edge;

            for (E e :busEdges) {
                if(e.from==n) {
                    connectedEdges.add(new dijsktraNode(e.to, this.cost+e.getWeight(),e) );


                }
            }

        }
    }

    public int[] getDijkstra(LinkedList<E> edges, int fromNode, int toNode)
    {
        this.fromNode=fromNode;
        this.toNode=toNode;
        this.busEdges = edges;

        //Addar startnod
        PQ.add(new dijsktraNode(fromNode,0,null));

        dijsktraNode DN;
        while (!PQ.isEmpty())
        {
            DN = PQ.peek();
            if(!DN.visited)
            {
                if(DN.nodeObject==toNode)
                    return DN.path;
                else
                    {
                        DN.visited=true;
                        for (dijsktraNode d:DN.connectedEdges)
                        {
                            if(!d.visited)
                            {
                                PQ.add(d);
                            }
                            
                        }

                    }
            }


        }


        return null;
    }


}
