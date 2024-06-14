package my.mood;

public class SelectionSort {

    // Implementation of Selection Sort
    public void selectionSort(int [] arr){
        int n = arr.length;

        for (int i = 0; i < n -1; i++){
            int min = i;

            for (int j = i + 1; j < n; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public void print(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        SelectionSort selectionSort = new SelectionSort();
        int [] array = {6, 3, 1, 4, 7, 5, 9, 8, 2};
        selectionSort.print(array);

        // Implementation of Selection Sort
        selectionSort.selectionSort(array);
        selectionSort.print(array);

    }
}
