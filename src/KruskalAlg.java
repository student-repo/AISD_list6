
import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class KruskalAlg
{
    class subset{
        int parent, rank;
    }

    int V;
    Heap<Edge> edge;


    KruskalAlg(int v, Edge edge[]){

        V = v;
        this.edge = new Heap<>((o1, o2) -> {
            if (o1.weight < o2.weight) return -1;
            if (o1.weight > o2.weight) return 1;
            return 0;
        });
        this.edge.builtHeap(edge);

    }

    int find(subset subsets[], int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMST()
    {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i=0; i<V; ++i)
            result[i] = new Edge();

        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();


        for (int v = 0; v < V; ++v){
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }


        while (!edge.isEmpty())
        {
            Edge next_edge = edge.extractMin();
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle,
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }

        double sum = 0;
        for (i = 0; i < e; ++i) {
            System.out.println((result[i].src + 1 )+" -- " + (result[i].dest + 1) + " == "+
                    result[i].weight);
            sum += result[i].weight;
        }
        System.out.println("sum : " + sum);

    }

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

