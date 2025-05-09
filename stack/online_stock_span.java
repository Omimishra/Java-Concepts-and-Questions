package stack;
import java.util.Stack;
public class online_stock_span {
    Stack<int[]>st;
    int i = 0;
    public online_stock_span() {
        // constructor
        st = new Stack<>();
    }
    
    public int next(int price) {
        // check if stack is empty or not
        // if empty then push the price and index
        // and return 1 as span
        while(!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }
        i++;
        // if stack is empty then return i as span
        // else return i - index of top element of stack
        int x = i- (st.isEmpty() ? 0 : st.peek()[1]);
        st.push(new int[]{price,i});
        return x;
    }
    public static void main(String[] args) {
        online_stock_span obj = new online_stock_span();
        System.out.println(obj.next(100)); // 1
        System.out.println(obj.next(80));  // 1
        System.out.println(obj.next(60));  // 1
        System.out.println(obj.next(70));  // 2
        System.out.println(obj.next(60));  // 1
        System.out.println(obj.next(75));  // 4
        System.out.println(obj.next(85));  // 6
    }
}
