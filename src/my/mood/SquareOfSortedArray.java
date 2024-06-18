package my.mood;

public class SquareOfSortedArray {

    // Square of sorted array in ascending order
    public int [] squareArray(int [] arr){
        int n = arr.length;
        int [] temp = new int [n];
        int i = 0;
        int j = n - 1;
        int k = n - 1;

        while (k >= 0){
            if (Math.abs(arr[i]) > Math.abs(arr[j])){
                temp[k] = arr[i] * arr[i];
                i++;
            }
            else {
                temp[k] = arr[j] * arr[j];
                j--;
            }
            k--;
        }
        return temp;
    }

    public void print(int [] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SquareOfSortedArray squareOfSortedArray = new SquareOfSortedArray();
        int [] arr = {-5, -2, -1, 0, 3, 6, 8, 11, 14, 19};
        squareOfSortedArray.print(arr);
        int [] temp = squareOfSortedArray.squareArray(arr);
        squareOfSortedArray.print(temp);

    }
}
