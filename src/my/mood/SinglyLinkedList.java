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

    // Displaying or printing Singly Linked List
    public void DisplaySinglyLinkedList(ListNode head){
        ListNode currentNode = head;
        System.out.println("Singly Linked List : ");

        while (currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("null\n");
    }

    // Calculating length of a Singly Linked List
    public int length(){
        if (head == null){
            return 0;
        }

        int count = 0;
        ListNode currentNode = head;

        while (currentNode != null){
            count+=1;
            currentNode = currentNode.next;
        }
        return count;
    }

    // Inserting node at the beginning of the Singly Linked List
    public void InsertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // Inserting node at the ending of the Singly Linked List
    public void InsertLast(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (null != temp.next){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Inserting node at a given position of the Singly Linked List
    public void InsertAtPosition(int position, int value){
        ListNode newNode = new ListNode(value);
        if (position == 1){
            newNode.next = head;
            head = newNode;
        }

        ListNode previous = head;
        int count = 0;
        while (count < position - 1){
            previous = previous.next;
            count++;
        }

        ListNode temp = previous.next;
        previous.next = newNode;
        newNode.next = temp;
    }

    // Deleting node at a beginning of the Singly Linked List
    public ListNode DeleteFirst(){
        if (head == null){
            return null;
        }

        ListNode temp = head;
        head = temp.next;
        temp.next = null;
        return temp;
    }

    // Deleting node at an ending of the Singly Linked List
    public ListNode DeleteLast(){
        if (head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        ListNode previous = null;

        while (temp.next != null){
            previous = temp;
            temp = temp.next;
        }

        previous.next = null;
        return temp;
    }

    // Deleting node at a given position of the Singly Linked List
    public void DeleteAtPosition(int Position){
        if (Position == 1){
            head = head.next;
        }

        ListNode previous = head;
        int count = 1;

        while (count < Position - 1){
            previous = previous.next;
            count++;
        }

        ListNode temp = previous.next;
        previous.next = temp.next;
    }

    // Searching element in a Singly Linked List
    public boolean SearchElement(int searchKey){
        if (head == null){
            return false;
        }

        ListNode temp = head;

        while (temp != null){
            if (temp.data == searchKey){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Reversing a Singly Linked List
    public ListNode ReverseList(){
        if (head == null){
            return null;
        }

        ListNode temp = head;
        ListNode previous = null;
        ListNode next;

        while (temp != null){
            next = temp.next;
            temp.next = previous;
            previous = temp;
            temp = next;
        }
        return previous;
    }

    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        // Adding data or element to a node
//        singlyLinkedList.head = new ListNode(10);
//        ListNode second = new ListNode(20);
//        ListNode third = new ListNode(25);
//        ListNode fourth = new ListNode(30);
//        ListNode fifth = new ListNode(35);

        // Assigning data of next node to previous node (reference)
//        singlyLinkedList.head.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = fifth;
//        fifth.next = null;

        // Displaying or printing Singly Linked List
        singlyLinkedList.DisplaySinglyLinkedList(singlyLinkedList.head);

        // Calculating length of a Singly Linked List
        System.out.println("Length of a Singly Linked List - " + singlyLinkedList.length());

        // Inserting node at the beginning of the Singly Linked List
        singlyLinkedList.InsertFirst(11);
        singlyLinkedList.InsertFirst(23);
        singlyLinkedList.DisplaySinglyLinkedList(singlyLinkedList.head);

        // Inserting node at the ending of the Singly Linked List
        singlyLinkedList.InsertLast(32);
        singlyLinkedList.InsertLast(12);
        singlyLinkedList.InsertLast(25);
        singlyLinkedList.DisplaySinglyLinkedList(singlyLinkedList.head);

        // Inserting node at a given position of the Singly Linked List
        singlyLinkedList.InsertAtPosition(1,5);
        singlyLinkedList.InsertAtPosition(singlyLinkedList.length(),8 );
        singlyLinkedList.InsertAtPosition(3,9);
        singlyLinkedList.InsertAtPosition(3,99);
        singlyLinkedList.DisplaySinglyLinkedList(singlyLinkedList.head);

        // Deleting node at a beginning of the Singly Linked List
        System.out.println(singlyLinkedList.DeleteFirst().data);
        System.out.println(singlyLinkedList.DeleteFirst().data);
        System.out.println(singlyLinkedList.DeleteFirst().data);
        singlyLinkedList.DisplaySinglyLinkedList(singlyLinkedList.head);

        // Deleting node at an ending of the Singly Linked List
        System.out.println(singlyLinkedList.DeleteLast().data);
        System.out.println(singlyLinkedList.DeleteLast().data);
        singlyLinkedList.DisplaySinglyLinkedList(singlyLinkedList.head);

        // Deleting node at a given position of the Singly Linked List
        singlyLinkedList.DeleteAtPosition(2);
        singlyLinkedList.DeleteAtPosition(3);
        singlyLinkedList.DisplaySinglyLinkedList(singlyLinkedList.head);

        // Searching element in a Singly Linked List
        if (singlyLinkedList.SearchElement(9)){
            System.out.println("element found!");
        }
        else {
            System.out.println("Element not found!");
        }

        // Reversing a Singly Linked List
        ListNode reverseList = singlyLinkedList.ReverseList();
        singlyLinkedList.DisplaySinglyLinkedList(reverseList);

    }
}
