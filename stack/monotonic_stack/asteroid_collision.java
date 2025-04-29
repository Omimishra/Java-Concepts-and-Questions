package stack.monotonic_stack;
//negative means left and positive means right
// if both are same then they will collide and both will be destroyed
import java.util.Stack;
public class asteroid_collision {
    public int[] collide(int [] arr){
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i]>0) st.push(arr[i]);
            else{
                while(!st.isEmpty()&& st.peek()>0&&st.peek()<Math.abs(arr[i])){//collision occurs as arr[i] is negative and st.peek() is positive , so we will remove smaller one
                    st.pop();
                }
                if(!st.isEmpty()&& st.peek()==Math.abs(arr[i])){
                    st.pop();// both will be destroyed
                }
                else if(st.isEmpty()||st.peek()<0){
                    st.push(arr[i]);// if st is empty (we r pushing neg element as it will go left so it will not collide even if a positive element is present next )or top of stack is negative then we can push the current element... 
                }
            }
        }
        int ans[] = new int[st.size()];
        for(int i =st.size()-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        asteroid_collision obj = new asteroid_collision();
        int arr[] = { 5, 10, -5 };
        int res[] = obj.collide(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
