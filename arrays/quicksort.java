package arrays;
public class quicksort {
    //worst case o(n^2)
    //average case o(nlogn)
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i<j) {
            while(arr[i] <= pivot && i<=high-1) {
                i++;
            }
            while(arr[j] > pivot && j>=low+1) {
                j--;
            }
            if(i<j)
            {
            // swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        return j;// pivot index
    }

    public static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pidx = partition(arr, low, high);
            sort(arr, low, pidx - 1);
            sort(arr, pidx + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 7, 3, 8, 2, 9 };
        int n = arr.length;
        sort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
