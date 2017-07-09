public class Task1 {
    public static void main(String[] args) {
        Heap<Integer> h = new Heap<>((o1, o2) -> o1 - o2);
        Heap<String> hh = new Heap<>((o1, o2) -> o1.length() - o2.length());
        Heap<Edge> hhh = new Heap<>((o1, o2) -> {
            if (o1.weight < o2.weight) return -1;
            if (o1.weight > o2.weight) return 1;
            return 0;
        });
//        Heap<Edge> hhh = new Heap<>((o1, o2) -> o1.weight - o2.weight);

        hh.insert("a");
        hh.insert("aaaaa");
        hh.insert("aa");
        hh.insert("aaaa");
        hh.insert("aaa");

        hh.decreaseKey(3, "");

        System.out.println(hh.extractMin());
        System.out.println(hh.extractMin());
        System.out.println(hh.extractMin());
        System.out.println(hh.extractMin());
        System.out.println();


//        Integer ii[] = {1, 12, 11, 144};
        Integer ii[] = {23, 31, 1, -23, 12, 55, 4, 6, 7, 123, -213, 0};

        h.builtHeap(ii);
//        h.insert(1);
//        h.insert(12);
//        h.insert(11);
//        h.insert(114);

//        h.decreaseKey(1, 5);

        System.out.println();
        System.out.println();
        h.printHeap();

        System.out.println(h.extractMin());
        h.printHeap();
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println();

//        Graph.Edge ff = new Graph.Edge();
//        hhh.insert(new Graph.Edge());

    }
}
