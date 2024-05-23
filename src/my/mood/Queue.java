package my.mood;

import java.util.NoSuchElementException;

public class Queue {

    // Creating instance variable 'front' and 'rear'
    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    // Enqueue operation
    public void enQueue(int data){
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
    public void deQueue(){
        if (isEmpty()){
        throw new NoSuchElementException("Queue is Empty!");
        }

        int result = front.data;
        front = front.next;

        if (front == null){
            rear = null;
        }

        length--;
    }

    // Printing an elements of Queue
    public void print(){
        ListNode current = front;

        while (current != null){
            System.out.print(current.data+ " -> ");
            current = current.next;
        }
        System.out.println("null");

    }

    // getting first element of queue
    public int first(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is Empty!");
        }

        return front.data;
    }

    // getting last element of queue
    public int last(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is Empty!");
        }

        return rear.data;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue operation
        queue.enQueue(12);
        queue.enQueue(17);
        queue.enQueue(19);
        queue.print();

        // first and last element of queue
        System.out.println(queue.first());
        System.out.println(queue.last());

        // Dequeue operation
        queue.deQueue();
        queue.deQueue();
        queue.print();

    }
}
