import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DijkstraAlgorithm {



    public Map<Integer, Integer> getPredecessors() {
        return predecessors;
    }


    private final List<Edge> edges;
    private Set<Integer> settledNodes;
    private Heap<Integer> unSettledNodes;
    private Map<Integer, Double> distance;
    private Map<Integer, Integer> predecessors;

    public Map<Integer, Double> getDistance() {
        return distance;
    }

    public DijkstraAlgorithm(List<Edge> edges) {
        this.edges = new ArrayList<Edge>(edges);
    }

    public void execute(Integer source) {
        unSettledNodes = new Heap<>((o1, o2) -> o1 - o2);
        settledNodes = new HashSet<Integer>();
        distance = new HashMap<Integer, Double>();
        predecessors = new HashMap<Integer, Integer>();
        distance.put(source, (double) 0);
        unSettledNodes.insert(source);
        while (!unSettledNodes.isEmpty()) {
            Integer node = unSettledNodes.extractMin();
            if(node != null){
                settledNodes.add(node);
                findMinimalDistances(node);
            }

        }
    }

    private void findMinimalDistances(Integer node) {
        List<Integer> adjacentNodes = getNeighbors(node);
        for (Integer target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.insert(target);
            }
        }

    }

    private double getDistance(Integer node, Integer target) {
        for (Edge edge : edges) {
            if (edge.getSrc() == node
                    && edge.getDest() == target) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    public List<Integer> getNeighbors(Integer node) {
        List<Integer> neighbors = new ArrayList<Integer>();
        for (Edge edge : edges) {
            if (edge.getSrc() == node
                    && !isSettled(edge.getDest())) {
                neighbors.add(edge.getDest());
            }
        }
        return neighbors;
    }


    private boolean isSettled(Integer vertex) {
        return settledNodes.contains(vertex);
    }

    private double getShortestDistance(Integer Dest) {
        if (distance.containsKey(Dest)){
            return distance.get(Dest);
        }
        return Double.MAX_VALUE;
    }

    public LinkedList<Integer> getPath(Integer target) {
        LinkedList<Integer> path = new LinkedList<Integer>();
        Integer step = target;
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }

    public static List<Edge> getEdges(List<String> lines) {

        List<Edge> edges = new ArrayList<>();
//        Edge[] edges = new Edge[E];
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

            edges.add(new Edge(v1 - 1, v2 - 1, d));

        }
        return edges;

    }

}