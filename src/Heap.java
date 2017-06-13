
import java.util.*;

public class Heap<T> {
    private int size;
    private List<Node> heap;
    final private Comparator<T> comparator;

    private class Node {
        public T element;
        public int position;
    }

    public Heap( Comparator<T> comparator ) {
        size = 0;
        heap = new ArrayList<Node>();

        this.comparator = comparator;

    }

    public void insert( final T element ) {
        size++;
        Node node = new Node();
        node.element = element;
        node.position = size-1;
        heap.add(node);
        decreaseKey( node );
    }

    public void clear() {
        heap.clear();
        size = 0;
    }

    public T top() {
        return heap.get(0).element;
    }
    
    public T extractMin() {
        T returnNode = top();
        exchange( 0, size-1 );
        heap.remove(size-1);
        size--;
        
        if (size>0) {
            heapify( heap.get(0) );
        }

        return returnNode;
    }
    

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private boolean decreaseKey( final Node node ) {
        int index = node.position;
        boolean modified = false;

        while ( index>0 &&  comparator.compare(heap.get(parent(index)).element, heap.get(index).element ) >= 0 ) {
            exchange( index, parent(index) );
            index = parent(index);
            modified = true;
        }

        return modified;
    }

    public boolean decreaseKey(int index, T key) {
        boolean modified = false;
        heap.get(index).element = key;

        while ( index > 0 &&  comparator.compare(heap.get(parent(index)).element, heap.get(index).element ) >= 0 ) {
            exchange( index, parent(index) );
            index = parent(index);
            modified = true;
        }

        return modified;
    }


    private void heapify( final Node node ) {
        int smallest;
        int index = node.position;
        int left = left(index);
        int right = right(index);

        if (left<size && comparator.compare(heap.get(left).element, heap.get(index).element) <= 0 )
            smallest= left;
        else
            smallest = index;

        if (right<size && comparator.compare(heap.get(right).element, heap.get(smallest).element ) <=0 )
            smallest= right;
        if (smallest!= index) {
            exchange( index, smallest );
            heapify( heap.get(smallest) );
        }
    }

    private void exchange( final int index, final int index2 ) {
        Node temp = heap.get(index);
        temp.position = index2;

        Node temp2 = heap.get(index2);
        temp2.position = index;

        heap.set(index, temp2 );
        heap.set( index2, temp);

    }


    private int parent(final int i) {
        return i/2;
    }

    private int left(final int i) {
        return 2 * i + 1;
    }

    private final int right(final int i) {
        return 2 * i + 2;
    }

    private void buildHeap(ArrayList<Node> nodes) {
        size = nodes.size();
        heap = nodes;

        for (int i = size / 2; i >= 0; i--) {
            heapify(heap.get(i));
        }
    }

    public void builtHeap( final T[] elements ) {
        ArrayList<Node> nodes = new ArrayList<>();
        int i = 0;
        for (T e: elements) {
            Node n = new Node();
            n.position = i;
            n.element = e;
            nodes.add(n);
                    i++;
        }
        buildHeap(nodes);
    }

    public void printHeap() {
        for(Node n : heap) {
            System.out.println("index: " + n.position + " = " + n.element);
        }
    }
}