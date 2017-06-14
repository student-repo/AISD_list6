public class MinHeapNode {

    private double key;
    private int vertex;

    public MinHeapNode(double key, int vertex) {
        this.key = key;
        this.vertex = vertex;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public double getKey() {
        return key;
    }

    public void setKey(double key) {
        this.key = key;
    }
}