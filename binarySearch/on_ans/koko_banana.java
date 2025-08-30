package binarySearch.on_ans;

public class koko_banana {
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int TotalHours(int[] arr, int mid) {
        int hours = 0;
        for (int i = 0; i < arr.length; i++) {
            hours += Math.ceil((double) arr[i] / (double) mid);
        }
        return hours;
    }

    public static int kokobanana(int[] arr, int k) {
        int low = 1;
        int high = findMax(arr);
        while (low <= high) {
            int mid = (low + high) / 2;
            int hours = TotalHours(arr, mid);
            if (hours <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 30, 11, 23, 4, 20 };
        int k = 6;
        int ans = kokobanana(arr, k);
        System.out.println("The answer is: " + ans);
    }
}
