package recursion.basic;
public class powerofx {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        // Convert n to a long integer to handle the edge case with Integer.MIN_VALUE
        long N = n;

        // If n is negative, take the reciprocal of x and make N positive
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        // If N is even, recursively compute the square of x^(N/2)
        if (N % 2 == 0) {
            return myPow(x * x, (int) (N / 2));
        } 
        // If N is odd, recursively compute x^(N-1) and multiply it by x
        else {
            return x * myPow(x, (int) (N - 1));
        }
    }
    public static void main(String[] args) {
        double x = 2;
        int n = 5;
        double ans = myPow(x, n);
        System.out.println(ans);
    }
}