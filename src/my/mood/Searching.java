package my.mood;

public class Searching {

    // implementation of Linear Search
    public int linearSearch(int [] arr, int search){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == search){
                System.out.println("Element " + arr[i] + " found at index " + i);
            }
        }
        return -1;
    }

    // implementation of Binary Search
    public int binarySearch(int [] arr, int search){
        int first = 0;
        int last = arr.length-1;
        while (first <= last){
            int middle = (first + last) / 2;
            if (arr[middle] == search){
                System.out.println("Element " + arr[middle] + " found at index " + middle);
            }
            if (search < arr[middle]){
                last = middle-1;
            }
            else {
                first = middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Searching searching = new Searching();
        int [] array = {21, 42, 72, 12, 99, 77, 23, 52, 78, 34};
        int [] array1 = {12, 32, 40, 45, 67, 69, 72, 78, 93, 98};

        // implementation of Linear Search
        System.out.println(searching.linearSearch(array, 103));
        searching.linearSearch(array, 99);

        // implementation of Binary Search
        searching.binarySearch(array1, 93);
        System.out.println(searching.binarySearch(array1, 47));

    }
}
