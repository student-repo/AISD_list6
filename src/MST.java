// A Java program for Prim's Minimum Spanning Tree (MST) algorithm.
// The program is for adjacency matrix representation of the graph

import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class MST
{
    // Number of vertices in the graph
    private static final int V=5;

    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST stored in
    // parent[]
//    void printMST(int parent[], int n, int graph[][])
//    {
//        System.out.println("Edge   Weight");
//        for (int i = 1; i < V; i++)
//            System.out.println(parent[i]+" - "+ i+"    "+
//                    graph[i][parent[i]]);
//    }
    void printMST(int parent[], int n)
    {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i]+" - "+ i+"    ");
    }

    // Function to construct and print MST for a graph represented
    //  using adjacency matrix representation
    void primMST(Edge[] edges)
    {
        // Array to store constructed MST
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int [V];



//        Heap<Edge> edge = new Heap<>((o1, o2) -> {
//            if (o1.weight < o2.weight) return -1;
//            if (o1.weight > o2.weight) return 1;
//            return 0;
//        });
//        edge.builtHeap(edges);



        // To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[V];

        // Initialize all keys as INFINITE
//        for (int i = 0; i < V; i++)
//        {
//            key[i] = Integer.MAX_VALUE;
//            mstSet[i] = false;
//            Edge e = edge.top();
//            e.weight =
//            edge.decreaseKey(0, )
//        }

        // Always include first 1st vertex in MST.
        key[0] = 0;     // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST

//        // The MST will have V vertices
//        while (!hheeaapp.isEmpty()) {
//            int u = hheeaapp.extractMin();
//
//            for(Vertex v : adj.get(u)) {
//                if (mstSet[v.vertexID] == false && v.weight <  key[v.vertexID]){
//                    parent[v.vertexID]  = u;
//                    key[v.vertexID] = v.weight;
//                }
//            }
//        }





//        for (int count = 0; count < V-1; count++)
//        {
//            // Pick thd minimum key vertex from the set of vertices
//            // not yet included in MST
//            int u = minKey(key, mstSet);
////            int u = key.extractMin();
//
//            // Add the picked vertex to the MST Set
//            mstSet[u] = true;
//
//            // Update key value and parent index of the adjacent
//            // vertices of the picked vertex. Consider only those
//            // vertices which are not yet included in MST
//            for(Vertex v : adj.get(u)) {
//                if (mstSet[v.vertexID] == false && v.weight <  key[v.vertexID]){
//                    parent[v.vertexID]  = u;
////                    key.decreaseKey(v.vertexID, v.weight);
//                    key[v.vertexID] = v.weight;
//                }
//            }
//        }

        // print the constructed MST
        printMST(parent, V);
    }


    void primMST(int [][] graph)
    {
        // Array to store constructed MST
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int [V];

        // To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0;     // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < V; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v]!=0 && mstSet[v] == false &&
                        graph[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = graph[u][v];
                }
        }

        // print the constructed MST
        printMST(parent, V);
    }

    private static class Vertex {
        int vertexID;
        int weight;

        public Vertex(int vertexID, int weight) {
            this.vertexID = vertexID;
            this.weight = weight;
        }
    }

    public static void main (String[] args)
    {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */

//        Map<Integer, ArrayList<Vertex>> foo = new HashMap<>();
//        foo.put(0, new ArrayList<>(Arrays.asList(new Vertex(1, 2), new Vertex(3, 6))));
//
//        foo.put(1, new ArrayList<>(Arrays.asList(new Vertex(0, 2), new Vertex(2, 3), new Vertex(3, 8), new Vertex(4, 5))));
//
//        foo.put(2, new ArrayList<>(Arrays.asList(new Vertex(1, 3), new Vertex(4, 7))));
//
//        foo.put(3, new ArrayList<>(Arrays.asList(new Vertex(0, 6), new Vertex(4, 9))));
//
//        foo.put(4, new ArrayList<>(Arrays.asList(new Vertex(3, 9), new Vertex(2, 7))));

//        Edge[] edges = {new Edge(0, 1, 2.0), new Edge(1, 2, 3.0), new Edge(1, 3, 8.0), new Edge(1, 4, 5.0), new Edge(2, 4, 7.0),
//                new Edge(4, 3, 9.0), new Edge(3, 0, 6.0)};




        MST t = new MST();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        Edge[] edges = new Edge[7];
        edges[0] = new Edge(0, 1, 2);
        edges[1] = new Edge(0, 3, 6);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 8);
        edges[4] = new Edge(1, 4, 5);
        edges[5] = new Edge(2, 4, 7);
        edges[6] = new Edge(3, 4, 9);


        // Print the solution
        t.primMST(graph);
        System.out.println();
        System.out.println();
        System.out.println();
//        t.primMST(foo);
    }
}
// This code is contributed by Aakash Hasija