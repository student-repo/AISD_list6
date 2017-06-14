import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sibendu Dey on 3/30/2017.
 *
 * Why -> To find the minimum spanning tree for a connected graph
 *
 * How ->
 *    1. Create a minheap to track the vertices with minimum key values.
 *    2. For every minimum heap node , adjust the key values of all the adjacent vertices if the
 *       present key value is greater than the edge weight. and mark the heap node as visited
 *    3. Update the parent array to keep track of edges involved in forming the MST.
 *
 * Time complexity -> To be investigated by 1st April 2017.
 *
 *
 */
public class PrimAlg {

    public static void main(String args[]) {
        ArrayList<Edge> edges = new ArrayList<>();
//        edges.add(new Edge(0, 1, 33));
//        edges.add(new Edge(1, 2, 44));
//        edges.add(new Edge(2, 0, 11));
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));

//        Graph graph = GraphBuilder.createGraphWithWeight();
//        MinHeap minHeap = new MinHeap(graph.getVertices());
        MinHeap minHeap = new MinHeap(5);
//        performPRIMOptimized(graph, minHeap);
        performPRIMOptimized(5,edges, minHeap);
    }

    public static void performPRIMOptimized(int vertexNumber, List<Edge> edgesList, MinHeap minHeap) {

        boolean visited[] = new boolean[vertexNumber];
        int parent[] = new int[vertexNumber];
        parent[0] = -1;
        while (minHeap.getSize() != 0) {
            MinHeapNode node = minHeap.extractMin();
            System.out.print(node.getVertex() + " ");
            visited[node.getVertex()] = true;
                        for (Edge edge : getAdjEdgesList(node.getVertex(), edgesList)) {
                if (!visited[edge.getDest()] && minHeap.getNodes()[minHeap.getPos()[edge.getDest()]].getKey() > edge.getWeight()) {
                    minHeap.decreaseKey(edge.getDest(),edge.getWeight());
                    parent[edge.getDest()] = edge.getSrc();
                }
            }
        }
        printSolution(parent);
    }

    public static List<Edge> getAdjEdgesList(int v, List<Edge> edgesList){
        List<Edge> vAdjList = new ArrayList<Edge>();
        for(Edge e : edgesList) {
            if(e.dest == v || e.src == v) {
                vAdjList.add(e);
            }
        }
        return vAdjList;
    }

    private static void printSolution(int[] parent) {

        for ( int i = 1 ; i < parent.length ; i++)
            System.out.println(parent[i] + "->" + i);
    }


}
