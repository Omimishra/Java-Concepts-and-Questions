package arrays;
public class mergesort {
    public static void divide(int arr[], int st, int end) {
        // o(log n)
        if (st >= end) {
            return;
        }
        int mid = st + (end - st) / 2;
        divide(arr, st, mid);
        divide(arr, mid + 1, end);
        conquer(arr, st, mid, end);
    }

    public static void conquer(int arr[], int st, int mid, int end) {
        // o(n)
        int n1 = mid-st+1;
        int n2 = end-mid;
        
        int left[] = new int[n1];
        int right[] = new int[n2];
        
        for (int i = 0 ; i<n1;i++){
            left[i] = arr[st+i];
        }
        for (int i = 0 ; i<n2;i++){
            right[i] = arr[mid+i+1];
        }
        
        int i = 0; 
        int j= 0 ; 
        int k = st;
        
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
            
            while(i<n1){
                arr[k] = left[i];
                i++;
                k++;
            }
            while(j<n2){
                arr[k] = right[j];
                j++;
                k++;
            }
        }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 3, 5, 1, 3, 4, 1, 9 };
        divide(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
