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

    public static void main(String[] args) {

        MergeTwoSortedArray mergeTwoSortedArray = new MergeTwoSortedArray();
        int [] array = {2, 5, 7, 12, 22, 24, 32};
        int [] array2 = {13, 15, 17, 19, 23, 34, 39};
        mergeTwoSortedArray.print(array);
        mergeTwoSortedArray.print(array2);

        // Combining two sorted array
        int [] merge = mergeTwoSortedArray.merge(array, array2);
        mergeTwoSortedArray.print(merge);

    }
}

