package my.mood;

public class BinaryHeap {
    public Integer [] heap;
    public int n;

    public BinaryHeap(int capacity){
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int getSize(){
        return n;
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(5);

        System.out.println(binaryHeap.isEmpty());
        System.out.println(binaryHeap.getSize());
    }
}
