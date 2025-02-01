package my.mood;

public class Arrays {

    // printing each element of array
    public static void printArray(int [] arr){

        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Remove Even integers from an array
    public static int [] removeEven(int [] arr){
        int oddCount = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                oddCount++;
            }
        }

        int [] Result = new int [oddCount];
        int index = 0;
         for (int j : arr) {
            if (j % 2 != 0) {
                Result[index] = j;
                index++;
            }
        }
        return Result;
    }

    // Reverse an array
    // method - 1
    public static void reverseArray(int [] arr){
        for (int i = arr.length-1; i > -1; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /* method - 2
    public static void reverseArray(int [] arr, int start, int end){
        while (start < end){
            int temp;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    } */

    // Finding Minimum value in an Array
    public static void MinValue(int [] arr){
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        System.out.println(min);
    }

    // Finding Maximum value in an Array
    public static void MaxValue(int [] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        System.out.println(max);
    }

    // Finding Second Max value in an array
    public static void SecMaxValue(int [] arr){
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > max) {
                secMax = max;
                max = j;
            } else if (j > secMax && j != max) {
                secMax = j;
            }
        }
        System.out.println(secMax);
    }

    // Moving all zeroes to end of an array
    public static void moveZeroes(int [] arr){
        int j = 0; // --> j focus on zeroth element
        for (int i = 0; i < arr.length; i++){
            // --> i focus on non-zeroth element
            if (arr[i] != 0 && arr[j] == 0){
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0){
                j++;
            }
        }
    }

    public static void arrayDemo(){
        int [] arr3 = {1,4,0,9,5,0,7,0,8,0,2};
        printArray(arr3);

        moveZeroes(arr3);
        printArray(arr3);
    }

    // Resizing an Array
    public  static int [] resizeArray(int [] arr, int capacity){
        int [] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    // Finding missing number in an array
    public static void missingNum(int [] arr){
        int n = arr.length+1;
        int sum = n*(n+1)/2;
        for (int e : arr){
            sum-=e;
        }
        System.out.println(sum);
    }

    // Check whether string is Palindrome or not
    public static boolean isPalindrome(String name){
        char [] charArr = name.toCharArray();
        int start = 0;
        int last = name.length()-1;

        while (start < last){
            if (charArr[start] != charArr[last]){
                return false;
            }
            start++;
            last--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Array declaration and initialization
        int [] Arr2 = new int[5];

        // Adding or updating element in Array
        Arr2[0] = 4;
        Arr2[1] = 5;
        Arr2[2] = 6;
        Arr2[3] = 8;
        Arr2[4] = 12;
        printArray(Arr2);
        // Arr2[6] = 90;
        Arr2[3] = 7;
        printArray(Arr2);

        // Remove even integers from an array
        int [] Arr = {1,2,3,4,5,6,7,8,9,10};
        printArray(Arr);
        printArray(removeEven(Arr));

        // Reverse an array
        reverseArray(Arr);
        // reverseArray(Arr, 0, Arr.length-1);
        // printArray(Arr);

        // Finding Minimum value in an Array
        MinValue(Arr2);
        MinValue(Arr);

        // Finding Maximum value in an Array
        MaxValue(Arr2);
        MaxValue(Arr);

        // Finding Second Maximum value in an Array
        SecMaxValue(Arr);
        SecMaxValue(Arr2);

        // Moving all zeroes to end of an array
        arrayDemo();

        // Resizing an array
        System.out.println("Length of an array 'Arr' before resizing : " + Arr.length);
        printArray(Arr);
        printArray(resizeArray(Arr,14));
        System.out.println("Length of an array 'Arr' after resizing : " + resizeArray(Arr,14).length);

        // Finding missing number in an array
        int [] arr4 = {1,2,3,4,5,7,8};
        missingNum(arr4);

        // Check whether string is Palindrome or not
        if (isPalindrome("Shrunal"))
            System.out.println("The name is a Palindrome");

        else
            System.out.println("The name is not a Palindrome");

        System.out.println(isPalindrome("sanas"));

    }
}
