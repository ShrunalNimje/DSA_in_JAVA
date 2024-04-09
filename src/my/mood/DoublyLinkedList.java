package my.mood;

import java.util.NoSuchElementException;

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

    // Inserting node at the given position of the doubly linked list
    public void insertPosition(int data, int position){
        ListNode newNode = new ListNode(data);

        if (position <= 0 || position > length + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1){
            if (head != null){
                newNode.next = head;
                head.previous = newNode;
            }
            head = newNode;
            length++;
        }

        ListNode temp = head;
        int count = 1;

        while (count < position-1 && temp != null){
            temp = temp.next;
            count++;
        }

        if (temp == null){
            System.out.println("Invalid position!");
        }

        ListNode next = temp.next;
        temp.next = newNode;
        newNode.previous = temp;
        newNode.next = next;

        if (next != null){
            next.previous = newNode;
        }
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

    // deleting first node from doubly linked list
    public void deleteFirst(){
        if (EmptyList()){
            throw new NoSuchElementException("List is Empty!");
        }

        ListNode temp = head;

        if (head == tail){
            tail = null;
        }
        else {
            head.next.previous = null;
        }

        head = head.next;
        temp.next = null;
        length--;
    }

    // delete node from a give position in doubly linked list
    public void deletePosition(int position){
        if (EmptyList()){
            throw new NoSuchElementException("list is Empty!");
        }

        if (position <= 0 && position > length+1){
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1 ){
            head = head.next;
            if (head != null){
                head.previous = null;
            }
            length--;
            return;
        }

        int count = 1;
        ListNode current = head;
        ListNode previous = null;
        while (count < position && current != null){
            previous = current;
            current = current.next;
            count++;
        }

        if (current == null){
            System.out.println("Invalid Position!");
            return;
        }

        previous.next = current.next;
        if (current.next != null){
            current.next.previous = previous;
        }
        length--;

    }

    // delete last node from doubly linked list
    public void deleteLast(){
        if (EmptyList()){
            throw new NoSuchElementException("List is Empty!");
        }

        ListNode temp = tail;
        if (head == tail){
            head = null;
        }
        else {
            tail.previous.next = null;
        }

        tail = tail.previous;
        temp.previous = null;
        length--;
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

        // deleting first node from doubly linked list
        doublyLinkedList1.deleteFirst();
        doublyLinkedList1.deleteFirst();
        doublyLinkedList1.deleteFirst();
        doublyLinkedList1.displayForward();

        // deleting first node from doubly linked list
        doublyLinkedList1.deleteLast();
        doublyLinkedList1.deleteLast();
        doublyLinkedList1.deleteLast();
        doublyLinkedList1.displayForward();

        doublyLinkedList1.insertPosition(23, 2);
        doublyLinkedList1.displayForward();
        doublyLinkedList1.deletePosition(3);
        doublyLinkedList1.displayForward();

    }
}
