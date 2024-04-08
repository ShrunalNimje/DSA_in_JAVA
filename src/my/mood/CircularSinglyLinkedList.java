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

    // creating Circular Singly Linked list
    public void createList(){
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(12);
        ListNode fourth = new ListNode(23);
        ListNode fifth = new ListNode(13);
        ListNode sixth = new ListNode(65);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = first;

        last = sixth;
    }

    public void displayList(){
        if (last == null){
            System.out.println("List is Empty!");
            return;
        }

        ListNode first = last.next;

        while (first != last){
            System.out.print(first.data + " ");
            first = first.next;
            length++;
        }

        System.out.println(first.data);
        length++;
        System.out.println(getLength());
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
        circularSinglyLinkedList.createList();
        circularSinglyLinkedList.displayList();
    }
}
