package my.mood;

public class BubbleSort {

    // Implementation of Bubble sort
    public void bubbleSort(int [] arr){
        int n = arr.length;
        boolean isSwapped;

        for (int i = 0; i < n -1; i++){
            isSwapped = false;

            for (int j = 0; j < n - 1 - i; j++){

                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }

            if (!isSwapped){
                System.out.println("\nArray is sorted using Bubble sort!");
                break;
            }
        }
    }

    // accessing element of Bubble Sort
    public void print(int [] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();
        int [] array = {6, 3, 1, 4, 7, 5, 9, 8, 2};
        bubbleSort.print(array);

        // Implementation of Bubble sort
        bubbleSort.bubbleSort(array);
        bubbleSort.print(array);

    }
}
