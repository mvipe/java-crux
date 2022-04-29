package Heap;

public class HeapClient {
    public static void main(String[] args) {
        CustomHeap heap=new CustomHeap();
        heap.display();
        heap.add(20);
        heap.add(10);
        heap.add(30);
        heap.display();
        heap.delete();
        heap.display();
        heap.delete();
        heap.display();
        heap.delete();
        heap.display();
        heap.delete();
        heap.display();

    }
}
