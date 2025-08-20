package binarySearch.on_ans;

public class sqrt {
    public static int floorSqrt(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            long square = mid * mid;
            if (square >= (long) n) {
                high = (int) mid - 1; // Move to the left side
            } else {
                low = (int) mid + 1; // Move to the right side
            }
        }
        return high; // 'high' will be the largest integer whose square is less than or equal to 'n'
    }

    public static void main(String[] args) {
        int n = 16;
        int result = floorSqrt(n);
        System.out.println("The floor of the square root of " + n + " is: " + result);
    }
}
