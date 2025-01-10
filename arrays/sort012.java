package arrays;

public class sort012 {

    public static void sortarray(int arr[]) {
        int ct0 = 0, ct1 = 0, ct2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                ct0++;
            else if (arr[i] == 1)
                ct1++;
            else
                ct2++;
        }
        for (int i = 0; i < ct0; i++) {
            arr[i] = 0;
        }
        for (int i = ct0; i < ct0 + ct1; i++) {
            arr[i] = 1;
        }
        for (int i = ct0 + ct1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }

    public static void sortarray_optimized(int arr[]) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high--);
                    break;
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1 };
        sortarray_optimized(arr);
        System.out.println("After sorting:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
