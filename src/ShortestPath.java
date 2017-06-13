


import java.util.*;

class ShortestPath
{
    static final int INF=Integer.MAX_VALUE;
   public class AdjListNode
    {
        private int v;
        private int weight;
        AdjListNode(int _v, int _w) { v = _v;  weight = _w; }
       public int getV() { return v; }
        public int getWeight()  { return weight; }
        public String toString(){
            return String.valueOf(v);
        }
    }

    // Class to represent graph as an adjcency list of
    // nodes of type AdjListNode
    class Graph
    {
        private int V;
        public LinkedList<AdjListNode>adj[];
        Graph(int v)
        {
            V=v;
            adj = new LinkedList[V];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList<AdjListNode>();
        }
        void addEdge(int u, int v, int weight)
        {
            AdjListNode node = new AdjListNode(v,weight);
            adj[u].add(node);// Add v to u's list
        }

        // A recursive function used by shortestPath.
        // See below link for details
        void topologicalSortUtil(int v, Boolean visited[], Stack stack)
        {
            // Mark the current node as visited.
            visited[v] = true;

            for(AdjListNode node : adj[v]){
                if (!visited[node.getV()])
                    topologicalSortUtil(node.getV(), visited, stack);
            }
            // Push current vertex to stack which stores result
            stack.push(new Integer(v));
        }

        // The function to find shortest paths from given vertex. It
        // uses recursive topologicalSortUtil() to get topological
        // sorting of given graph.
        void shortestPath(int s)
        {
            Stack stack = new Stack();
            int dist[] = new int[V];

            // Mark all the vertices as not visited
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to store Topological
            // Sort starting from all vertices one by one
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);

            // Initialize distances to all vertices as infinite and
            // distance to source as 0
            for (int i = 0; i < V; i++)
                dist[i] = INF;
            dist[s] = 0;

            while (stack.empty() == false)
            {
                int u = (int)stack.pop();
                if (dist[u] != INF)
                {
                    for(AdjListNode a : adj[u])
                    {
                        if (dist[a.getV()] > dist[u] + a.getWeight())
                            dist[a.getV()] = dist[u] + a.getWeight();
                    }
                }
            }

            for (int i = 0; i < V; i++)
            {
                if (dist[i] == INF)
                    System.out.print( "INF ");
                else
                    System.out.print( dist[i] + " ");
            }
        }
    }

    // Method to create a new graph instance through an object
    // of ShortestPath class.
    Graph newGraph(int number)
    {
        return new Graph(number);
    }

    public static void main(String args[])
    {
        // Create a graph given in the above diagram.  Here vertex
        // numbers are 0, 1, 2, 3, 4, 5 with following mappings:
        // 0=r, 1=s, 2=t, 3=x, 4=y, 5=z
        ShortestPath t = new ShortestPath();
        Graph g = t.newGraph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 0;
        System.out.println("Following are shortest distances "+
                "from source " + s );
        g.shortestPath(s);

        System.out.println("________________________________");

        for (LinkedList an : g.adj) {
            for(int i = 0; i < an.size(); i++ ) {
                System.out.println(an.get(i));
            }
            System.out.println();
            System.out.println();
        }
    }
}