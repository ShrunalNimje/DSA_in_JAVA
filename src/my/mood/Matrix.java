package my.mood;

public class Matrix {

    // search element in a sorted matrix
    public void search(int [][] matrix, int value){
        int i = 0;
        int j = matrix.length - 1;

        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == value){
                System.out.println(value + " found at index " + i + ", " + j);
                return;
            }

            if(matrix[i][j] > value){
                j--;
            }
            else {
                i++;
            }
        }
        System.out.println("Value not found!");
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();

        // search element in a sorted matrix
        int [][] myMatrix = {{11, 22, 33},
                             {34, 45, 46},
                             {48, 50, 54}};
        matrix.search(myMatrix, 34);

    }
}
