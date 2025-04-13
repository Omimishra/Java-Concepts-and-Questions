package stack.learning;
import java.util.*;
// stack implementation through single queue
public class queue_imp {
    class stack{
        Queue<Integer> q1 = new LinkedList<>();
        void push(int a){
            q1.add(a);
            // The loop iterates q1.size() - 1 times, removing the front element of the queue and adding it back to the end. This effectively moves the newly added element to the front of the queue, simulating the behavior of a stack.
            for(int i=0;i<q1.size()-1;i++){
                q1.add(q1.remove());
            }
        }
        int pop(){
            if(q1.isEmpty()){
                System.out.println("stack underflow");
            }
            return q1.remove();
        }
        int peek(){
            if(q1.isEmpty()){
                System.out.println("stack underflow");
            }
            return q1.peek();
        }   
    }
    public static void main(String[] args) {
        queue_imp q = new queue_imp();
        stack s = q.new stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.peek());
        System.out.println("Size of the stack before deleting any element " + s.q1.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.q1.size());
        System.out.println("Top of the stack after deleting an element " + s.peek());
    }
}
