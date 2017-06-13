class Edge implements Comparable<Edge> {
    int src, dest;
    double weight;

    public Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge() {}

    @Override
    public int compareTo(Edge compareEdge) {
        if (this.weight < compareEdge.weight) return -1;
        if (this.weight > compareEdge.weight) return 1;
        return 0;
    }


    // Comparator function used for sorting edges based on
    // their weight
//    public int compareTo(Edge compareEdge)
//    {
//        return this.weight-compareEdge.weight;
//    }
};