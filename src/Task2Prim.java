import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task2Prim {
    public static void main(String args[]) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("./src/config"));
//        List<String> lines = Files.readAllLines(Paths.get("./src/config2"));
//        List<String> lines = Files.readAllLines(Paths.get("./src/task2Example"));
        int V = Integer.parseInt(lines.get(0));
        lines.remove(0);
        lines.remove(0);


        MinHeap minHeap = new MinHeap(V);
        PrimAlg.performPRIMOptimized(V,DijkstraAlgorithm.getEdges(lines), minHeap);
    }
}
