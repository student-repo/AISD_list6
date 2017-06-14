//class Edge implements Comparable<Edge> {
//    int src, dest;
//    double weight;
//
//    public Edge(int src, int dest, double weight) {
//        this.src = src;
//        this.dest = dest;
//        this.weight = weight;
//    }
//
//    public Edge() {}
//
//    @Override
//    public int compareTo(Edge compareEdge) {
//        if (this.weight < compareEdge.weight) return -1;
//        if (this.weight > compareEdge.weight) return 1;
//        return 0;
//    }
//
//
//    // Comparator function used for sorting edges based on
//    // their weight
////    public int compareTo(Edge compareEdge)
////    {
////        return this.weight-compareEdge.weight;
////    }
//};
public class Edge implements Comparable<Edge> {

    int src, dest;
    double weight;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    public Edge() {}

    public Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
        if ( this.weight < o.getWeight() )
            return -1;
        else if ( this.weight > o.getWeight())
            return 1;
        else return 0;
    }
}
