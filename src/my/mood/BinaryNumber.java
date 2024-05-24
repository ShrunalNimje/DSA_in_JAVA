package my.mood;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryNumber {

    private ListNode front;
    private ListNode rear;
    private int length;

    private static class ListNode{
        private final String data;
        private ListNode next;

        public ListNode(String data){
            this.data = data;
        }
    }

    public boolean isEmpty(){
        return length == 0;
    }

    // Enqueue operation
    public void enQueue(String data){
        ListNode newNode = new ListNode(data);

        if (isEmpty()){
            front = newNode;
        }
        else {
            rear.next = newNode;
        }

        rear = newNode;
        length++;
    }

    // Dequeue operation
    public String deQueue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is Empty!");
        }

        String result = front.data;
        front = front.next;

        if (front == null){
            rear = null;
        }

        length--;
        return result;
    }

    // Generate binary number from 1 to n
    public String [] generateBinary(int n){

        String [] result = new String[n];
        enQueue("1");

        for (int i = 0; i < n; i++){
            result[i] = deQueue();
            String n1 = result[i]+ "0";
            String n2 = result[i]+ "1";
            enQueue(n1);
            enQueue(n2);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryNumber binaryNumber = new BinaryNumber();

        // Generate binary number from 1 to n
        System.out.println(Arrays.toString(binaryNumber.generateBinary(15)));

    }
}
