
import java.util.Scanner;

/**
 * Created by Sibendu dey on 3/24/2017.
 */
public class GraphBuilder {

    public static Graph createGraph() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of vertices");
        int noOfVertices = sc.nextInt();
        System.out.println("Enter no of edges");
        int noOfEdges = sc.nextInt();

        Graph graph = new Graph(noOfVertices, noOfEdges);

        for (int i = 0; i < noOfEdges; i++) {
            System.out.println("Enter source");
            int srcEdge = sc.nextInt();
            System.out.println("Enter destination");
            int destEdge = sc.nextInt();

            graph.getEdgesList().add(new Edge(srcEdge, destEdge));
        }

        return graph;
    }

    public static Graph createGraphWithWeight() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of vertices");
        int noOfVertices = sc.nextInt();
        System.out.println("Enter no of edges");
        int noOfEdges = sc.nextInt();

        Graph graph = new Graph(noOfVertices, noOfEdges);

        for (int i = 0; i < noOfEdges; i++) {

            //System.out.println("Enter source");
            int srcEdge = sc.nextInt();

            //System.out.println("Enter destination");
            int destEdge = sc.nextInt();

            //System.out.println("Enter weight");
            int weight = sc.nextInt();

            graph.getEdgesList().add(new Edge(srcEdge, destEdge, weight));
        }

        return graph;
    }

    public static Graph createGraphWithWeightAndAdjacencyList()   {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of vertices");
        int noOfVertices = sc.nextInt();
        System.out.println("Enter no of edges");
        int noOfEdges = sc.nextInt();

        Graph graph = new Graph(noOfVertices,noOfEdges);

        for ( int i = 0 ; i < noOfEdges ; i++)  {

            //System.out.println("Enter source");
            int srcEdge = sc.nextInt();

            //System.out.println("Enter destination");
            int destEdge = sc.nextInt();

            //System.out.println("Enter weight");
            float weight = sc.nextFloat();

            //graph.getEdgesList().add(new Edge(srcEdge , destEdge , weight));
            graph.addEdgeWithWeight(new Edge(srcEdge , destEdge , weight));
        }

        return  graph;
    }

    public static Graph createGraphWithAdjacencyList() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of vertices");
        int noOfVertices = sc.nextInt();
        System.out.println("Enter no of edges");
        int noOfEdges = sc.nextInt();

        Graph graph = new Graph(noOfVertices,noOfEdges);

        for ( int i = 0 ; i < noOfEdges ; i++)  {

            //System.out.println("Enter source");
            int srcEdge = sc.nextInt();

            //System.out.println("Enter destination");
            int destEdge = sc.nextInt();


            graph.addEdge(srcEdge , destEdge);
        }

        return  graph;
    }
}
