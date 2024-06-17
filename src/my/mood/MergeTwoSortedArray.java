package my.mood;

public class MergeTwoSortedArray {

    // Combining two sorted array
    public int [] merge(int [] arr, int [] arr2){
        int n = arr.length;
        int m = arr2.length;
        int k = 0;
        int i = 0;
        int j = 0;
        int [] result = new int[n + m];

        while (i < n && j < m){
            if (arr[i] < arr2[j]){
                result[k] = arr[i];
                i++;
                k++;
            }
            else {
                result[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < n){
            result[k] = arr[i];
            i++;
            k++;
        }

        while (j < m){
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }

    public void print(int [] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();
    }

    // Implementation of sorted array of 0's, 1's & 2's
    public void sort(int [] arr, int low, int high){
        int i = low;
        int j = low;
        int k = high;

        while (i <= k){
            if (arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }
            else if (arr[i] == 1){
                i++;
            }
            else if (arr[i] == 2) {
                swap(arr, i, k);
                k--;
            }
        }
    }

    public void swap(int [] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        MergeTwoSortedArray mergeTwoSortedArray = new MergeTwoSortedArray();
        int [] array = {2, 5, 7, 12, 22, 24, 32};
        int [] array2 = {13, 15, 17, 19, 23, 34, 39};
        mergeTwoSortedArray.print(array);
        mergeTwoSortedArray.print(array2);

        // Combining two sorted array
        int [] merge = mergeTwoSortedArray.merge(array, array2);
        mergeTwoSortedArray.print(merge);

        // Implementation of sorted array of 0's, 1's & 2's
        int [] array3 = {1, 0, 2, 0, 0, 1, 2, 1, 2, 1, 2, 0};
        mergeTwoSortedArray.print(array3);
        mergeTwoSortedArray.sort(array3, 0, array3.length - 1);
        mergeTwoSortedArray.print(array3);

    }
}

