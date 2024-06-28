package my.mood;

public class DynamicProgramming {

    // fibonacci series - Recursion
    /*
    This code of piece recursively calling itself again and again but
    this code recalculate value rather than storing that's why it increases time
     */
    public int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int left = fibonacci(n - 1);
        int right = fibonacci(n - 2);
        return left + right;
    }

    // Bottom - Up Approach - nth therm of Fibonacci series - Iteratively
    public int fibonacciBU(int n){
        int [] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;
        System.out.print(arr[0] + ", " + arr[1]);

        for (int i = 2; i <= n; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
            System.out.print(", " + arr[i]);
        }

        System.out.println();
        return arr[n];
    }

    // Top - Down Approach - nth therm of Fibonacci series - Recursively
    public int fibonacciTD(int n){
        int [] arr = new int[n + 1];

        if (arr[n] == 0){
            if (n == 0 || n == 1){
                arr[n] = n;
            }
            else {
                int left = fibonacciTD(n - 1);
                int right = fibonacciTD(n - 2);
                arr[n] = left + right;
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();

        // Fibonacci series - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,...
        System.out.println(dp.fibonacci(7));
        System.out.println(dp.fibonacciBU(8));
        System.out.println(dp.fibonacciTD(6));
    }
}
