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

    // Insert a value in Max Priority Queue
    public void insert(int value){
        if (n == heap.length-1){
             resize(2*heap.length);
        }

        n++;
        heap[n] = value;
        swim(n);
    }

    public void resize(int capacity){
        Integer [] temp = new Integer[capacity];

        for (int i = 1;  i < heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void swim(int a){
        while (a > 1 && heap[a/2] < heap[a]){
            int temp = heap[a];
            heap[a] = heap[a/2];
            heap[a/2] = temp;
            a = a/2;
        }
    }

    // delete maximum value in Max priority queue
    public int deleteMax(){
        System.out.println();
        int max = heap[1];
        swap(1,n);
        n--;

        sink(1);
        heap[n+1] = null;
        if (n > 0 && n == (heap.length-1)/4 ){
            resize(heap.length/2);
        }
        return max;
    }

    public void sink(int a){
        while (2*a <= n){
            int j = 2*a;

            if (j < n && heap[j] < heap[j+1]){
                j++;
            }
            if (heap[a] >= heap[j]){
                break;
            }

            swap(a, j);
            a = j;
        }
    }

    public void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    // Printing elements of Binary Heap
    public void printMaxPQ(){
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
        maxPQ.printMaxPQ();

        // delete max value in max priority queue
        System.out.println(maxPQ.deleteMax());
        System.out.println(maxPQ.deleteMax());
        maxPQ.printMaxPQ();

    }
}
