package binarySearch;

public class total_occurrence {
    public static int firstOccurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int[] firstAndLastPosition(int[] arr, int n, int k) {
        int first = firstOccurrence(arr, k);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = lastOccurrence(arr, k);
        return new int[] { first, last };
    }

    public static int count(int arr[], int n, int x) {
        int[] positions = firstAndLastPosition(arr, n, x);
        if (positions[0] == -1)
            return 0;
        return positions[1] - positions[0] + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 3, 4, 5 };
        int n = arr.length;
        int x = 2;
        int result = count(arr, n, x);
        System.out.println("Total occurrences of " + x + " is: " + result);
    }
}
