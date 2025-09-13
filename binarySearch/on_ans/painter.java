package binarySearch.on_ans;
public class painter {
    // Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint. You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.
    
public static int countPainters(int arr[],int mid){
    int painters = 1;// at least one painter is needed , stores no of painters
    long areaBoards = 0;// stores area of boards assigned to a painter
    for(int i =0;i<arr.length;i++){
        if(areaBoards + arr[i] <= mid){
            areaBoards += arr[i];
        }else{
            painters++;
            areaBoards = arr[i];
        }
    }
    return painters;
}
    public static int painterPartition(int arr[],int k){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i =0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        int low = max;
        int high = sum;
       
        while(low <= high){
            int mid = (low + high)/2;
            int painters = countPainters(arr, mid);
            if(painters <= k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
