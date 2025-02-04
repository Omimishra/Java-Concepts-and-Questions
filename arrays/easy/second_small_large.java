package arrays.easy;
class prog{
    public static int getSecondLargest(int[] arr) {
        // Code Here
        int n = arr.length;
        int large = Integer.MIN_VALUE;
        int sec_large = Integer.MIN_VALUE;
        
        if (n== 1 )
        return -1;
        if (n==2 && arr[0] == arr[1])
        return -1;
        
        for (int i = 0 ; i<n;i++){
                large = Math.max(large,arr[i]);
            }
            for(int i = 0 ; i<n;i++){
            if (arr[i]>sec_large && arr[i]!= large)
            {
                sec_large = arr[i];
            }
        }
        return sec_large;
    }
    public static int getSecondSmallest(int[] arr) {
        // Code Here
        int n = arr.length;
        int small = Integer.MAX_VALUE;
        int sec_small = Integer.MAX_VALUE;
        
        if (n== 1 )
        return -1;
        if (n==2 && arr[0] == arr[1])
        return -1;
        
        for (int i = 0 ; i<n;i++){
                small = Math.min(small,arr[i]);
            }
        for(int i = 0 ; i<n;i++){
            if (arr[i]<sec_small && arr[i]!= small)
            {
                sec_small = arr[i];
            }
        }
        return sec_small;
    }
    public static void main(String[] args) {
        int arr[] = {12, 35, 1, 10, 34, 1};
    int l = getSecondLargest(arr);
    int s = getSecondSmallest(arr);
    System.out.println("Second smallest element is: " + s);
    System.out.println("Second largest element is:" + l);
    }
}