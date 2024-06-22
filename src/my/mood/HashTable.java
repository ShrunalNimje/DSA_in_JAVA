package my.mood;

public class HashTable {

    public HashNode [] buckets;
    public int noOfBuckets;
    public int sizeOfTable;

    public HashTable(int capacity){
        this.noOfBuckets = capacity;
        this.sizeOfTable = 0;
        this.buckets = new HashNode[noOfBuckets];
    }

    public HashTable(){
        this(10);
    }

    // Implementation of HashNode in HashTable
    public static class HashNode {
        public int key;
        public String value;
        public HashNode next;

        public HashNode(int key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // returns size of table
    public int getSizeOfTable(){
        return sizeOfTable;
    }

    public boolean isEmpty(){
        return sizeOfTable == 0;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        System.out.println(hashTable.isEmpty());
        System.out.println(hashTable.getSizeOfTable());
        System.out.println(hashTable.noOfBuckets);

    }
}
