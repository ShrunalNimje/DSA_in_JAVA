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

    // put the key - value pair in HashTable
    public void put(int key, String value){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while (head != null){
            if (head.key == key){
                head.value = value;
                return;
            }
            head = head.next;
        }

        sizeOfTable++;
        head = buckets[bucketIndex];
        HashNode newNode = new HashNode(key, value);
        newNode.next = head;
        buckets[bucketIndex] = newNode;
    }

    public int getBucketIndex(int key){
        return key % noOfBuckets;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        System.out.println(hashTable.isEmpty());
        System.out.println(hashTable.getSizeOfTable());
        System.out.println(hashTable.noOfBuckets);

        hashTable.put(12, "Adam");
        hashTable.put(34, "Child");
        hashTable.put(22, "Nothing");
        hashTable.put(34, "Adam-1");
        System.out.println(hashTable.getSizeOfTable());

    }
}
