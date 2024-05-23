package my.mood;

import java.util.List;

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

    public static void main(String[] args) {
        Queue queue = new Queue();

    }
}
