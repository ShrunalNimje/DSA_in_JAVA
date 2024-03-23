package my.mood;
public class SinglyLinkedList {

    // Creating a head
    public ListNode head;

    // Creating a ListNode for SinglyLinkedList
    public static class ListNode{
        public int data;
        public ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void DisplaySinglyLinkedList(){
        ListNode currentNode = head;
        System.out.println("Singly Linked List : ");
        while (currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        // Adding data or element to a node
        singlyLinkedList.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(25);
        ListNode fourth = new ListNode(30);
        ListNode fifth = new ListNode(35);

        // Assigning data of next node to previous node (reference)
        singlyLinkedList.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        // Displaying or printing Singly Linked List
        singlyLinkedList.DisplaySinglyLinkedList();

    }
}
