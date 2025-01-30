package arrays;
public class next_permutation {

    public static void nextGreaterPermutation(int arr[]) {
        int n = arr.length; // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                // index i is the break point
                ind = i;
                break;
            }
        }
        if (ind == -1) {// If break point does not exist:
            // reverse the whole array:
            reverse(arr, 0);
        }
        // Step 2: Find the next greater element
        // and swap it with arr[ind]:
        for (int i = n - 1; i > ind; i--) {
            if (arr[i] > arr[ind]) {
                int tmp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = tmp;
                break;
            }
        }

        // Step 3: Reverse the array from ind+1 to n-1:
        reverse(arr, ind + 1);
    }
    public static void reverse(int arr[], int start) {
        int i = start, j = arr.length - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        }
    public static void main(String args[]) {
        int arr [] = { 2, 1, 5, 4, 3, 0, 0 };
        nextGreaterPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
