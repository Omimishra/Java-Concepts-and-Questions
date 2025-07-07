package recursion.subsequences_pattern;
import java.util.ArrayList;
public class print_all_subs_sum_k {
    public static void print_subsequences(ArrayList<Integer> res,int arr[],int i , int s,int sum){
        if(i==arr.length){
            if(s==sum){
                for(int j=0;j<res.size();j++){
                    System.out.print(res.get(j)+" ");
                }
                System.out.println();
            }
            return;
        }
        res.add(arr[i]);
        s+=arr[i];
        print_subsequences(res, arr, i + 1, s, sum); // include the current element
        res.remove(res.size() - 1); // backtrack
        s-=arr[i];
        print_subsequences(res, arr, i + 1, s, sum); // exclude the current element
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int sum = 2;
        ArrayList<Integer> res = new ArrayList<>();
        print_subsequences(res, arr, 0, 0, sum);
    }
}
