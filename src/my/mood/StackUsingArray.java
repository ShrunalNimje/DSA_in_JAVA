package my.mood;

public class StackUsingArray {
    public int top;
    public int [] arr;

    // Constructor with initial capacity
    public StackUsingArray(int capacity){
        top = -1;
        arr = new int[capacity];
    }

    // Constructor without capacity
    public StackUsingArray(){
        this(10); // by default capacity will be 10
    }

    // overFlow condition (Full Stack)
    public boolean overFlow(){
        return arr.length == top+1;
    }

    // underFlow condition (Empty Stack)
    public boolean underFlow(){
        return top == -1;
    }

    // Push operation
    public void push(int data){
        if (overFlow()){
            throw new RuntimeException("Stack is Full!");
        }

        top++;
        arr[top] = data;
    }

    // Pop operation
    public int pop(){
        if (underFlow()){
            throw new RuntimeException("Stack is Empty!");
        }

        int pop = arr[top];
        top--;
        return pop;
    }

    // Peek operation
    public int peek() {
        if (overFlow()) {
            throw new RuntimeException("Stack is Empty!");
        }

        return arr[top];
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(4);
        // Push operation
        stack.push(2);
        stack.push(3);

        // Pop operation
        System.out.println(stack.pop());

        // Peek operation
        System.out.println(stack.peek());

        StackUsingArray stack1 = new StackUsingArray();
        // Push operation
        stack1.push(12);
        stack1.push(3);

        // Pop operation
        System.out.println(stack1.pop());

        // Peek operation
        System.out.println(stack1.peek());

    }
}
