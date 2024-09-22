package arrays;
class Selection {
    static void selectionsort(int arr[], int n) {
        int i, j, temp;
        int min;
        for (i = 0; i < n - 1; i++) {
            min = i;
            for (j = i + 1; j < n; j++)
                if (arr[min] > arr[j])
                    min = j;
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

        }

    }

    public static void main(String[] args) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        selectionsort(arr, n);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}