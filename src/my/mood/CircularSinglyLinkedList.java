package my.mood;

public class CircularSinglyLinkedList {

    // creating instance variable 'last' from ListNode
    private ListNode last;
    private int length;

    // creating a ListNode for circular singly linked list
    public static class ListNode{
        public ListNode next;
        public int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public CircularSinglyLinkedList(){
        this.last = null;
        this.length = 0;
    }

    // return true when list is empty
    public boolean isEmpty(){
        return length == 0;
    }

    // return length of the list
    public int getLength(){
        return length;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
    }
}
