package my.mood;

public class QuickSort {

    // Implementation of Partitioning method for quick sort
    public int partitioning(int [] arr, int low, int high){
        int i = low;
        int j = low;
        int pivot = arr[high];

        while (i <= high){
            if (arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j - 1;
    }

    // Implementation of Recursively Quick Sort
    public void quickSort(int [] arr, int low, int high){
        if (low < high){
            int p = partitioning(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public void print(int [] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int [] array = {6, 3, 1, 4, 7, 5, 9, 8, 2};
        quickSort.print(array);
        quickSort.quickSort(array, 0, array.length - 1);
        quickSort.print(array);
    }
}
