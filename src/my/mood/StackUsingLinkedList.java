package my.mood;

import java.util.EmptyStackException;

public class StackUsingLinkedList {

    // Creating instance variable 'top'
    private ListNode top;
    private int length;

    // Creating a ListNode for Stack
    private static class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public StackUsingLinkedList(){
        this.top = null;
        this.length = 0;
    }

    // Return length of stack
    public int getLength() {
        return length;
    }

    // Return empty stack
    public boolean isEmpty() {
        return length == 0;
    }

    // Push operation for insertion data
    public int push(int data){
        ListNode newNode = new ListNode(data);

        newNode.next = top;
        top = newNode;
        length++;
        return top.data;
    }

    // Pop operation for deletion data
    public int pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }

        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    // Peek operation for top data
    public int peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        // Push operation for deletion data
        System.out.println(stack.push(3) + " element push");
        System.out.println(stack.push(12) + " element push");

        // Pop operation for deletion data
        System.out.println(stack.pop() + " element pop");

        // Peek operation for top data
        System.out.println("Peek element : " + stack.peek());

    }
}
