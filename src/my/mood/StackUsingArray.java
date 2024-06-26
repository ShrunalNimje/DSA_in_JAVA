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

    // Printing an elements of the stack
    public void print(){
        if (top == -1){
            System.out.println("null");
            return;
        }

        int current = 0;
        while (current <= top){
            System.out.print(arr[current]+ " -> ");
            current = current+1;
        }

        System.out.println("null");
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

    // Reversing a String using a Stack
    public static String reverseString(String s){
        StackUsingArray stackUsingArray = new StackUsingArray();
        char [] array = s.toCharArray();

        for (char c : array){
            stackUsingArray.push(c);
        }

        for (int i=0; i< s.length(); i++){
            array[i] = (char) stackUsingArray.pop();
        }
        return new String(array);
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(4);
        // Push operation
        stack.push(2);
        stack.push(3);
        stack.push(5);

        // Printing an elements of the stack
        stack.print();

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

        // Printing an elements of the stack
        stack.print();

        // Reversing a String using a Stack
        String s = "Shrunal";
        System.out.println("Before reverse : "+ s);
        System.out.println("After reverse : "+ reverseString(s));
    }
}
