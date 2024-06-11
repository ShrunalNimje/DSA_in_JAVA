package my.mood;

public class MaxPQ {

    public Integer [] heap;
    public int n;

    // Implementation of Binary Heap
    public MaxPQ(int capacity){
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int getSize(){
        return n;
    }

    // Insert a value in Binary heap
    public void insert(int value){
        if (n == heap.length-1){
            reSize(2* heap.length);
        }
        n++;
        heap[n] = value;
        swim(n);
    }

    private void reSize(int a) {
        Integer [] temp = new Integer[a];

        for (int i = 0; i < heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    private void swim(int k) {
        while (k > 1 && heap[k / 2] < heap[k]) {
            int temp = heap[k];
            heap[k] = heap[k / 2];
            heap[k / 2] = temp;
            k = k / 2; // because we need to continue shifting up till
            // new value inserted is at correct position
        }
    }

    // Printing elements of Binary Heap
    public void printMaxBinaryHeap(){
        for (int i = 1; i <= n; i++){
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ(5);

        System.out.println(maxPQ.isEmpty());
        System.out.println(maxPQ.getSize());

        // Insert a value in Max Binary heap
        maxPQ.insert(3);
        maxPQ.insert(5);
        maxPQ.insert(1);
        maxPQ.insert(23);
        maxPQ.insert(4);
        maxPQ.insert(13);
        maxPQ.insert(11);
        maxPQ.printMaxBinaryHeap();

    }
}
