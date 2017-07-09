import java.util.ArrayList;
import java.util.List;

public class PrimAlg {

    public static void performPRIMOptimized(int vertexNumber, List<Edge> edgesList, MinHeap minHeap) {

        boolean visited[] = new boolean[vertexNumber];
        int parent[] = new int[vertexNumber];
        parent[0] = -1;
        while (minHeap.getSize() != 0) {
            MinHeapNode node = minHeap.extractMin();
            visited[node.getVertex()] = true;
                        for (Edge edge : getAdjEdgesList(node.getVertex(), edgesList)) {
                if (!visited[edge.getDest()] && minHeap.getNodes()[minHeap.getPos()[edge.getDest()]].getKey() > edge.getWeight()) {
                    minHeap.decreaseKey(edge.getDest(),edge.getWeight());
                    parent[edge.getDest()] = edge.getSrc();
                }
            }
        }
        printSolution(parent, edgesList);
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

    public static double getEdgeWeight(List<Edge> edgesList, int src, int desc) {
        for(Edge e: edgesList) {
            if(e.dest == desc && e.src == src) {
                return e.weight;
            }
        }
        return 0;
    }

    private static void printSolution(int[] parent, List<Edge> edgesList) {

        double sum = 0;
        for ( int i = 1 ; i < parent.length ; i++){
            System.out.println(parent[i] + "->" + i + " == " + getEdgeWeight(edgesList, parent[i], i));
            sum += getEdgeWeight(edgesList, parent[i], i);
        }
        System.out.println("sum : " + sum);
    }


}
