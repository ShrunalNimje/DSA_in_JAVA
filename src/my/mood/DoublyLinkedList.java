package my.mood;

public class DoublyLinkedList {
    // creating a head
    private ListNode head;
    // creating a tail
    private ListNode tail;
    private int length;

    // creating a ListNode for doubly linked list
    public static class ListNode{
        public int data;
        public ListNode next;
        public ListNode previous;

        public ListNode(int data){
            this.data = data;
        }
    }

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public Boolean EmptyList(){
        return length == 0;
    }

    public int getLength(){
        return length;
    }

    // Printing elements of doubly linked list
    public void displayForward(){
        ListNode temp = head;

        System.out.print("Doubly Linked List in forward direction : ");
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        ListNode temp = tail;

        System.out.print("Doubly Linked List in backward direction : ");
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    // Inserting node at the beginning of the doubly linked list
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);

        if (EmptyList()){
            tail = newNode;
        }
        else {
            head.previous = newNode;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    // Inserting node at the end of the doubly linked list
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);

        if (EmptyList()){
            head = newNode;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
        length++;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(6);
        ListNode fourth = new ListNode(8);
        ListNode fifth = new ListNode(10);
        doublyLinkedList.head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        doublyLinkedList.tail = fifth;
        fifth.previous = fourth;
        fourth.previous = third;
        third.previous = second;
        second.previous = first;

        // Printing elements of doubly linked list
        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackward();

        DoublyLinkedList doublyLinkedList1 = new DoublyLinkedList();

        // Inserting node at the beginning of the doubly linked list
        doublyLinkedList1.insertFirst(2);
        doublyLinkedList1.insertFirst(4);
        doublyLinkedList1.insertFirst(2);
        doublyLinkedList1.insertFirst(4);
        doublyLinkedList1.displayForward();
        doublyLinkedList1.displayBackward();

        // Inserting node at the end of the doubly linked list
        doublyLinkedList1.insertLast(2);
        doublyLinkedList1.insertLast(5);
        doublyLinkedList1.insertLast(2);
        doublyLinkedList1.insertLast(5);
        doublyLinkedList1.displayForward();
        doublyLinkedList1.displayBackward();
    }
}
