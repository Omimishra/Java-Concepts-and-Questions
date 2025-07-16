package subsequences_pattern;

public class count_subs {
    public static int count(int i,int s,int sum,int arr[]){
        if(i==arr.length){
            if(sum==s){
                return 1; // found a subsequence with the required sum
            } else {
                return 0; // no subsequence found with the required sum
            }
        }
        int l = count(i+1,s+arr[i],sum,arr); // include the current element
        int r = count(i+1,s,sum,arr); // exclude the current element
        return l + r; // return the total count of subsequences found
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int sum = 2;
        int result = count(0, 0, sum, arr);
        System.out.println(result); // Output the count of subsequences with sum k
    }
}
