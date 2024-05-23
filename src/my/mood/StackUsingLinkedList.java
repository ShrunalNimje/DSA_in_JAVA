package my.mood;

import java.util.Arrays;
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

    // Printing the element of stack
    public void print(){
        ListNode current = top;
        while (current != null){
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.println("null");
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

    // Finding first next greater element to right direction in an element of an array
    public static int [] nextGreaterElement(int [] arr){
        int [] result = new int[arr.length];
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();

        for (int i = arr.length-1; i >= 0; i--){
            if (!stackUsingLinkedList.isEmpty()){
                while (!stackUsingLinkedList.isEmpty() && stackUsingLinkedList.peek() <= arr[i]){
                    stackUsingLinkedList.pop();
                }
            }

            if (stackUsingLinkedList.isEmpty()){
                result[i] = -1;
            }
            else {
                result[i] = stackUsingLinkedList.peek();
            }
            stackUsingLinkedList.push(arr[i]);

        }
        return result;
    }

    // Checking valid parenthesis
    public static boolean isValid(String s) {
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '['){
                stackUsingLinkedList.push(c);
            }

            else {
                if (stackUsingLinkedList.isEmpty()){
                    return false;
                }

                else {
                    int top = stackUsingLinkedList.peek();
                    if ((top == '[' && c == ']') ||
                            (top == '(' && c == ')') ||
                            (top == '{' && c == '}')){
                        stackUsingLinkedList.pop();
                    }

                    else {
                        return false;
                    }
                }
            }
        }
        return stackUsingLinkedList.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        // Push operation for deletion data
        System.out.println(stack.push(3) + " element push");
        System.out.println(stack.push(12) + " element push");
        System.out.println(stack.push(2) + " element push");
        System.out.println(stack.push(14) + " element push");
        System.out.println(stack.push(9) + " element push");

        // Printing an elements of a Stack
        stack.print();

        // Pop operation for deletion data
        System.out.println(stack.pop() + " element pop");
        System.out.println(stack.pop() + " element pop");

        // Printing an elements of a Stack
        stack.print();

        // Peek operation for top data
        System.out.println("Peek element : " + stack.peek());

        // Finding first next greater element to right direction in an element of an array
        int [] array = {8,4,6,7,1,9};
        System.out.println("Array : "+ Arrays.toString(array));
        System.out.println("Next greater element : " + Arrays.toString(nextGreaterElement(array)));

        // Checking Valid parenthesis
        String s = "[({)]";
        String s1 = "[(})]";
        String s2 = "[({})]";
        System.out.println("S : "+isValid(s));
        System.out.println("S1 : "+isValid(s1));
        System.out.println("S2 : "+isValid(s2));

    }
}
