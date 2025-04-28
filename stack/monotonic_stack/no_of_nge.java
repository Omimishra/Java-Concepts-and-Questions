package stack.monotonic_stack;
import java.util.Stack;
public class no_of_nge {
    public int[] count_nge(int n,int arr[], int queries, int indices[]){
        Stack<Integer> asc = new Stack<>();
        Stack<Integer> desc = new Stack<>();
        int v[] = new int[n];
        int ans[] = new int[queries];
        for(int i =n-1;i>=0;i--){
            while(!asc.isEmpty()&& arr[i]>=asc.peek()){
                desc.push(asc.pop());
            }
            desc.push(arr[i]);
            v[i] = asc.size();
            while(!desc.isEmpty()){
                asc.push(desc.pop());
            }
        }
        for(int i =0;i<queries;i++){
            ans[i] = v[indices[i]];
        }
        return ans;
    }
    public static void main(String[] args) {
        no_of_nge obj = new no_of_nge();
        int arr[] = { 5, 7, 1, 2, 6, 0 };
        int queries = 3;
        int indices[] = { 0, 1, 2 };
        int res[] = obj.count_nge(arr.length, arr, queries, indices);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
