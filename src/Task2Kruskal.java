import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by ubuntu-master on 13.06.17.
 */
public class Task2Kruskal {
    public static void main (String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./src/config"));
//        List<String> lines = Files.readAllLines(Paths.get("./src/config2"));
        int V = Integer.parseInt(lines.get(0));
        lines.remove(0);


        Graph graph = new Graph(V, Graph.getEdges(lines));
        graph.KruskalMST();



        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
//        Graph graph = new Graph(4, new Edge[]{new Edge(0, 1, 10.0), new Edge(0, 2, 6.0), new Edge(0, 3, 5.0), new Edge(1, 3, 15.0), new Edge(2, 3, 4.0)});

//        Edge[] eee = {new Edge(0, 1, 0.33), new Edge(1, 2, 0.33)};
//        Graph graph = new Graph(3, eee);
//        Edge[] eee = getEdges(lines);
//        for(Edge e : eee) {
//            System.out.println("src: " + e.src + " desc: " + e.dest + " weight: " + e.weight);
//        }
//
//        System.out.println(V);
//        graph.KruskalMST();
    }
}
