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
    public void DisplaySinglyLinkedList(){
        ListNode currentNode = head;
        System.out.print("Singly Linked List : ");

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

    // Finding middle node of the singly linked list
    public ListNode MiddleNode(){
        if (head == null){
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    // Finding the nth node from the end of the singly linked list
    public ListNode nthNodeFromEnd(int n){
        if (head == null){
            return null;
        }

        if (n <= 0){
            throw new IllegalArgumentException("Invalid value of n = "+ n);
        }

        int count = 0;
        ListNode temp = head;
        ListNode next = head;

        while (count < n){
            if (next == null){
                throw new IllegalArgumentException(n + " is greater than the no. of nodes in list");
            }

            next = next.next;
            count++;
        }

        while (next != null){
            next = next.next;
            temp = temp.next;
        }
        return temp;
    }

    // Removing the duplicate node from the sorted singly linked list
    public void RemoveDuplicateNode(){
        if (head == null){
            return;
        }
        ListNode temp = head;
        while (temp.next != null){
            if (temp.data ==temp.next.data ){
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
    }

    // Inserting node in sorted singly linked list
    public ListNode InsertInSortedList(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            return newNode;
        }

        ListNode temp = head;
        ListNode previous = null;

        while (temp != null && temp.data < newNode.data){
                previous = temp;
                temp = temp.next;
        }

        newNode.next = temp;
        previous.next = newNode;
        return head;
    }

    // Removing a key from the singly linked list
    public Boolean RemoveKey(int key){
        if (head == null){
            return false;
        }

        ListNode temp = head;
        ListNode previous = null;

        while (temp != null && temp.data == key){
            head = temp.next;
            return true;
        }

        while (temp != null && temp.data != key){
            previous = temp;
            temp = temp.next;
        }

        if (temp == null){
            return false;
        }
        previous.next = temp.next;
        return true;
    }

    // Checking whether Loop contains in the Singly Linked List or not
    public Boolean ContainsLoop(){
        if (head == null){
            return false;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    public void CreateLoop(){
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(9);
        ListNode fourth = new ListNode(8);
        ListNode fifth = new ListNode(7);
        ListNode sixth = new ListNode(1);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = fourth;
    }

    // Finding starting node of the loop in Singly Linked List
    public ListNode FirstNodeOfLoop(){
        if (head == null){
            return null;
        }

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr){
                return GetFirstNodeOfLoop(slowPtr);
            }
        }
        return null;
    }

    public ListNode GetFirstNodeOfLoop(ListNode slowPtr){
        ListNode temp = head;

        while (temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    // Removing a loop from the singly linked list
    public void RemoveLoop(){
        if (head == null){
            return;
        }

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr){
                RemoveLoop(slowPtr);
                return;
            }
        }
    }

    private void RemoveLoop(ListNode slowPtr){
        ListNode temp = head;

        while (temp.next != slowPtr.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    // Merging two sorted singly linked list
    public static ListNode MergeTwoList(ListNode a, ListNode b, int data){
        ListNode copy = new ListNode(data);
        ListNode temp = copy;

        while (a != null && b != null){
            if (a.data <= b.data){
                temp.next = a;
                a = a.next;
            }
            else {
                temp.next = b;
                b = b.next;
            }

            temp = temp.next;
        }

        if (a == null){
            temp.next = b;
        }
        else {
            temp.next = a;
        }

        return copy.next;
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
        singlyLinkedList.DisplaySinglyLinkedList();

        // Calculating length of a Singly Linked List
        System.out.println("Length of a Singly Linked List - " + singlyLinkedList.length());

        // Inserting node at the beginning of the Singly Linked List
        singlyLinkedList.InsertFirst(11);
        singlyLinkedList.InsertFirst(23);
        singlyLinkedList.DisplaySinglyLinkedList();

        // Inserting node at the ending of the Singly Linked List
        singlyLinkedList.InsertLast(32);
        singlyLinkedList.InsertLast(12);
        singlyLinkedList.InsertLast(25);
        singlyLinkedList.DisplaySinglyLinkedList();

        // Inserting node at a given position of the Singly Linked List
        singlyLinkedList.InsertAtPosition(1,5);
        singlyLinkedList.InsertAtPosition(singlyLinkedList.length(),8 );
        singlyLinkedList.InsertAtPosition(3,9);
        singlyLinkedList.InsertAtPosition(3,99);
        singlyLinkedList.DisplaySinglyLinkedList();

        // Deleting node at a beginning of the Singly Linked List
        System.out.println(singlyLinkedList.DeleteFirst().data);
        System.out.println(singlyLinkedList.DeleteFirst().data);
        System.out.println(singlyLinkedList.DeleteFirst().data);
        singlyLinkedList.DisplaySinglyLinkedList();

        // Deleting node at an ending of the Singly Linked List
        System.out.println(singlyLinkedList.DeleteLast().data);
        System.out.println(singlyLinkedList.DeleteLast().data);
        singlyLinkedList.DisplaySinglyLinkedList();

        // Deleting node at a given position of the Singly Linked List
//        singlyLinkedList.DeleteAtPosition(2);
//        singlyLinkedList.DeleteAtPosition(3);
//        singlyLinkedList.DisplaySinglyLinkedList(singlyLinkedList.head);

        // Searching element in a Singly Linked List
        if (singlyLinkedList.SearchElement(9)){
            System.out.println("element found!");
        }
        else {
            System.out.println("Element not found!");
        }

        // Reversing a Singly Linked List
//        ListNode reverseList = singlyLinkedList.ReverseList();
//        singlyLinkedList.DisplaySinglyLinkedList(reverseList);

        // Finding middle node of the singly linked list
        singlyLinkedList.DisplaySinglyLinkedList();
        ListNode m = singlyLinkedList.MiddleNode();
        System.out.println("middle node - "+ m.data);

        // Finding the nth node from the end of the singly linked list
        singlyLinkedList.DisplaySinglyLinkedList();
        ListNode node = singlyLinkedList.nthNodeFromEnd(3);
        System.out.println("Third last node - " + node.data);

        // Removing the duplicate node from the sorted singly linked list
        singlyLinkedList.InsertFirst(45);
        singlyLinkedList.InsertFirst(45);
        singlyLinkedList.InsertFirst(23);
        singlyLinkedList.InsertFirst(14);
        singlyLinkedList.InsertFirst(12);
        singlyLinkedList.InsertFirst(12);
        singlyLinkedList.DeleteLast();
        singlyLinkedList.DeleteLast();
        singlyLinkedList.DeleteLast();
        singlyLinkedList.DeleteLast();
        singlyLinkedList.RemoveDuplicateNode();
        singlyLinkedList.DisplaySinglyLinkedList();

        // Inserting node in sorted singly linked list
        singlyLinkedList.InsertInSortedList(30);
        singlyLinkedList.DisplaySinglyLinkedList();
        singlyLinkedList.InsertInSortedList(60);
        singlyLinkedList.InsertInSortedList(18);
        singlyLinkedList.DisplaySinglyLinkedList();

        // Removing a key from the singly linked list
        if (singlyLinkedList.RemoveKey(60)){
            System.out.println("Key removed!");
            singlyLinkedList.DisplaySinglyLinkedList();
        }
        else{
            System.out.println("Entered wrong key!");
        }

        // Checking whether loop contains in Singly Linked List or not
        singlyLinkedList.CreateLoop();
        if (singlyLinkedList.ContainsLoop()){
            System.out.println("Singly Linked List contains loop!");
        }
        else{
            System.out.println("Singly Linked List not contains loop!");
        }

        // Finding starting node of the loop in Singly Linked List
        System.out.println("starting node of the loop in Singly Linked List : " + singlyLinkedList.FirstNodeOfLoop().data);

        // Removing a loop from the singly linked list
        singlyLinkedList.RemoveLoop();
        singlyLinkedList.DisplaySinglyLinkedList();

        // Merging two sorted singly linked list
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        singlyLinkedList1.InsertFirst(65);
        singlyLinkedList1.InsertFirst(23);
        singlyLinkedList1.InsertFirst(15);
        singlyLinkedList1.DisplaySinglyLinkedList();

        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        singlyLinkedList2.InsertFirst(34);
        singlyLinkedList2.InsertFirst(23);
        singlyLinkedList2.InsertFirst(10);
        singlyLinkedList2.DisplaySinglyLinkedList();

        SinglyLinkedList mergeTwo = new SinglyLinkedList();
        mergeTwo.head= MergeTwoList(singlyLinkedList1.head, singlyLinkedList2.head, 0);
        mergeTwo.DisplaySinglyLinkedList();

    }
}
