// Java program for Kruskal's algorithm to find Minimum Spanning Tree
// of a given connected, undirected and weighted graph
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class Graph
{
    // A class to represent a graph edge


    // A class to represent a subset for union-find
    class subset
    {
        int parent, rank;
    };

    int V;    // V-> no. of vertices & E->no.of edges
    Heap<Edge> edge;

    // Creates a graph with V vertices and E edges
    Graph(int v, Edge edge[]){

        V = v;
        this.edge = new Heap<>((o1, o2) -> {
            if (o1.weight < o2.weight) return -1;
            if (o1.weight > o2.weight) return 1;
            return 0;
        });
        this.edge.builtHeap(edge);

    }

    // A utility function to find set of an element i
    // (uses path compression technique)
    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y
    // (uses union by rank)
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    void KruskalMST()
    {
        Edge result[] = new Edge[V];  // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i=0; i<V; ++i)
            result[i] = new Edge();

        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
//        Arrays.sort(edge);

        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();

        // Create V subsets with single elements

        for (int v = 0; v < V; ++v){
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }


        // Number of edges to be taken is equal to V-1
        while (!edge.isEmpty())
        {
            // Step 2: Pick the smallest edge. And increment the index
            // for next iteration
            Edge next_edge = edge.extractMin();
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle, include it
            // in result and increment the index of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println((result[i].src + 1 )+" -- " + (result[i].dest + 1) + " == "+
                    result[i].weight);
    }

//    void handleIntput(BST bst, String s){
//        if(s.equals("max")){
//            bst.max();
//        }
//        else if(s.equals("min")){
//            bst.min();
//        }
////        else if(s.equals("display_tree")){
////            bst.displayTree();
////        }
//        else if(s.equals("inorder")){
//            bst.inorder();
//        }
//        else if(s.substring(0, s.indexOf(" ")).equals("insert")){
//            bst.insert(Integer.parseInt(s.substring(s.indexOf(" ")).substring(1)));
//        }
//        else if(s.substring(0, s.indexOf(" ")).equals("delete")){
//            bst.delete(Integer.parseInt(s.substring(s.indexOf(" ")).substring(1)));
//        }
//        else if(s.substring(0, s.indexOf(" ")).equals("find")){
//            bst.find(Integer.parseInt(s.substring(s.indexOf(" ")).substring(1)));
//        }
//    }

    public static Edge[] getEdges(List<String> lines) {
        int E = Integer.parseInt(lines.get(0));
        lines.remove(0);


        Edge[] edges = new Edge[E];
        int i = 0;

        for(String line : lines) {
            Matcher matcher = Pattern.compile("\\d+").matcher(line);
            matcher.find();
            line = line.substring(line.indexOf(" "), line.length());;
            int v1 = Integer.valueOf(matcher.group());
            matcher.find();
            int v2 = Integer.valueOf(matcher.group());



            Pattern p = Pattern.compile("(\\d+(?:\\.\\d+))");

            double d = 0.0;
            Matcher m = p.matcher(line);
            while(m.find()) {
                d = Double.parseDouble(m.group(1));
            }
            edges[i] = new Edge(v1 - 1, v2 - 1, d);

            i ++;
        }
        return edges;

    }

}

