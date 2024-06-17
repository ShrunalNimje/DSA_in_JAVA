package my.mood;

public class MergeSort {

    // Implementation of Merge Sort
    public void mergeSort(int [] arr, int [] temp, int low, int high){
        if (low < high){
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    public void merge(int [] arr, int [] temp, int low, int mid, int high){
        for (int i = low; i <= high; i++){
            temp[i] = arr[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high){
            if (temp [i] < temp[j]){
                arr[k] = temp[i];
                i++;
            }
            else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            arr[k] = temp[i];
            k++;
            i++;
        }

        while(j <= high){
            arr[k] = temp[j];
            k++;
            j++;
        }
    }

    public void print(int [] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int [] array = {6, 3, 1, 4, 7, 5, 9, 8, 2};
        int [] array2 = new int[array.length];
        mergeSort.print(array);

        mergeSort.mergeSort(array, array2, 0, array.length - 1);
        mergeSort.print(array);

    }
}
