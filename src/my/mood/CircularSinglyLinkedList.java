package my.mood;

import java.util.NoSuchElementException;

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

    // printing elements of Circular singly linked list
    public void displayList(){
        if (last == null){
            System.out.println("List is Empty!");
            return;
        }

        ListNode first = last.next;

        while (first != last){
            System.out.print(first.data + " ");
            first = first.next;
        }

        System.out.println(first.data);
    }

    // Inserting node at the beginning of the Circular Singly Linked List
    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);

        if (isEmpty()){
            last = newNode;
        }
        else {
            newNode.next = last.next;
        }

        last.next = newNode;
        length++;
    }

    // Inserting node at the ending of the Circular Singly Linked List
    public void insertLast(int data){
        ListNode newNode = new ListNode(data);

        if (isEmpty()){
            last = newNode;
            last.next = last;
        }
        else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }

        length++;
    }

    // Removing first node from circular singly linked list
    public int removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("List is Empty!");
        }

        ListNode first = last.next;
        if (first != last){
            last.next = first.next;
            first.next = null;
        }
        else {
            last = null;
        }
        length--;
        return first.data;
    }

    // Removing first node from circular singly linked list
    public void removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException("List is Empty!");
        }

        ListNode first = last.next;
        ListNode temp = first;
        ListNode previous = null;

        while (temp != last){
            previous = temp;
            temp = temp.next;
        }

        if (first != last){
            previous.next = first;
            last = previous;
        }
        else {
            last = null;
        }

        length--;
    }

    public static void main(String[] args) {
        // Creating instance of the class
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
        circularSinglyLinkedList.createList();
        circularSinglyLinkedList.displayList();

        CircularSinglyLinkedList circularSinglyLinkedList1 = new CircularSinglyLinkedList();
        // Inserting node at the beginning of the Circular Singly Linked List
        circularSinglyLinkedList1.insertFirst(23);
        circularSinglyLinkedList1.insertFirst(12);

        // Inserting node at the ending of the Circular Singly Linked List
        circularSinglyLinkedList1.insertLast(1);
        circularSinglyLinkedList1.insertLast(4);
        circularSinglyLinkedList1.displayList();

        // Removing first node from circular singly linked list
        circularSinglyLinkedList1.removeFirst();
        System.out.println("Node removed : "+ circularSinglyLinkedList1.removeFirst());
        circularSinglyLinkedList1.displayList();

        // Removing last node from circular singly linked list
        circularSinglyLinkedList1.removeLast();
        circularSinglyLinkedList1.displayList();

    }
}
