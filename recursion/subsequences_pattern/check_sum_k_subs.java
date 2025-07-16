package subsequences_pattern;
public class check_sum_k_subs {
   public static boolean check(int arr[], int i, int s, int sum) {
     if(s>sum) return false;
        if (i == arr.length) {
           if(sum==s){
                return true; // found a subsequence with the required sum
           }
           else {
                return false; // no subsequence found with the required sum
           }
        }
        // include the current element
        if(check( arr, i + 1, s+arr[i], sum)) {
            return true; // if found in the included case
        }
        // exclude the current element
        if(check(arr, i + 1, s, sum)) {
            return true; // if found in the excluded case
        }
        return false; // no subsequence found with the required sum
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int sum = 2;
        boolean result = check(arr, 0, 0, sum);
        System.out.println(result ? "Yes" : "No");
    }
}
