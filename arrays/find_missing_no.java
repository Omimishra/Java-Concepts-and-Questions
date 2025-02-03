package arrays;
//finding the missing number within a range of array 0 to n
public class find_missing_no {
    public static int find(int a[]){ // summation formula
        int n = a.length;
        int sum =(n*(n+1))/2;
        int s2=0;
        for(int i =0;i<n;i++){
            s2+=a[i];
        }
        return sum-s2;
    }
    public static void main(String[] args) {
        int a[] = {9,6,4,2,3,5,7,0,1};
        System.out.println(find(a));
    }
}
