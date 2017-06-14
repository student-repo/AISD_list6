import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task3 {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("./src/dijkstraExample"));
//        List<String> lines = Files.readAllLines(Paths.get("./src/task3"));

        lines.remove(0);
        lines.remove(0);
        int startVertex = Integer.parseInt(lines.get(0));
        lines.remove(0);
        List<Edge> edges = DijkstraAlgorithm.getEdges(lines);


        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(edges);
        dijkstra.execute(startVertex);


        System.out.println();
        System.out.println();


        for (Integer vertex : dijkstra.getDistance().keySet()) {
            int ff = vertex;
            int fofo;
            System.out.println("------------ source id: " + (startVertex + 1) + " target id: " + (vertex + 1)+ " distance: " + dijkstra.getDistance().get(vertex) + " ------------");
            while(dijkstra.getPredecessors().get(ff) != null){
                fofo = dijkstra.getPredecessors().get(ff);
                System.out.println((fofo  + 1)+ " " + (ff  + 1 ) + " " + getEdgeweight(edges, fofo, ff));
                ff = fofo;
            }
        }



        System.out.println();
        System.out.println("Predecessors");
        for (Integer vertex : dijkstra.getPredecessors().keySet()) {
            System.out.println("Predecessors [" + vertex + "] = " + dijkstra.getPredecessors().get(vertex));
        }

        System.out.println();
        System.out.println("Distance");
        for (Integer vertex : dijkstra.getDistance().keySet()) {
            System.out.println("Distance[" + vertex + "] = " + dijkstra.getDistance().get(vertex));
        }


    }

    public static double getEdgeweight(List<Edge> edges, int src, int dst) {
        for(Edge e : edges ) {
            if(e.dest == dst && e.src == src) {
                return e.weight;
            }
        }
        return 0;
    }
}

