package arrays;

class insertion {
    static void insertionsort(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            int key = arr[i];
            for (int j = 0; j < i; j++) {

                if (arr[j] > key) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = { 4,1,3,5,9,7 };
        int n = arr.length;
        insertionsort(arr, n);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
