package binarySearch.on_ans;

public class min_pgs {
    public static int cntStudents(int []arr, int pages){
        int students = 1;// no. of students
        long pgs = 0;// pages assigned to a student.
        for(int i =0;i<arr.length;i++){
            if(pgs+arr[i]<=pages){
                pgs+=arr[i];
            }
            else{
                students++;
                pgs=arr[i];
            }
        }
        return students;
    }
    public static int minPages(int []arr,int k){
        int sum =0;
        int maxi=Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            sum+=arr[i];
            maxi = Math.max(maxi, arr[i]);
        }
        int low = maxi, high = sum;
        while(low<=high){
            int mid=(low+high)/2;
            if(cntStudents(arr, mid)<=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int []arr={12,34,67,90};
        int k=2;
        int ans = minPages(arr, k);
        System.out.println("The minimum no. of pages is: "+ans);
    }
    
}
