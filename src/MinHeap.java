public class MinHeap {



    private int size;
    private MinHeapNode[] nodes = null;
    private int pos[];

    public MinHeap(int size) {
        this.size = size;
        nodes = new MinHeapNode[size];
        pos = new int[size];
        initializeNodes();
        initializePositions();
    }

    public int[] getPos() {
        return pos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void initializeNodes() {
        nodes[0] = new MinHeapNode(0 , 0);
        for (int i = 1; i < nodes.length; i++)
            nodes[i] = new MinHeapNode(Integer.MAX_VALUE, i);
    }

    public MinHeapNode[] getNodes() {
        return nodes;
    }

    public void initializePositions() {
        for (int i = 0; i < pos.length; i++)
            pos[i] = i;
    }

    public MinHeapNode extractMin() {
        if (size == 0)
            return null;

        MinHeapNode minNode = nodes[0];
        // Swap the node and decrement the current heap size
        swapNodes(0, size - 1);
        size--;
        // Perform heapify starting from 0th index
        heapify(0);
        return minNode;
    }

    private void heapify(int currPos) {
        int smallestIndex = currPos;
        if (2 * currPos + 1 < size && nodes[2 * currPos + 1].getKey() <
                nodes[currPos].getKey())
            smallestIndex = 2 * currPos + 1;

        if (2 * currPos + 2 < size && nodes[2 * currPos + 2].getKey() <
                nodes[smallestIndex].getKey())
            smallestIndex = 2 * currPos + 1;

        if (smallestIndex != currPos) {
            swapNodes(smallestIndex, currPos);
            heapify(smallestIndex);
        }
    }

    private void swapNodes(int smallestIndex, int currPos) {
        MinHeapNode temp = nodes[smallestIndex];
        nodes[smallestIndex] = nodes[currPos];
        nodes[currPos] = temp;
        pos[nodes[currPos].getVertex()] = currPos;
        pos[nodes[smallestIndex].getVertex()] = smallestIndex;
    }

    public void decreaseKey(int vertex, double newKey) {
//        System.out.println("Entered decrease key for vertex: " + vertex + " and key:" + newKey);
        int i = pos[vertex];
        nodes[i].setKey(newKey);

        while (i > 0 && nodes[(i - 1)/2].getKey() > nodes[i].getKey()) {
            pos[nodes[i].getVertex()] = (i - 1)/2;
            pos[nodes[(i - 1)/2].getVertex()] = i;
            swapNodes((i - 1)/2, i);
            i = ( i - 1)/ 2;
        }
    }


}