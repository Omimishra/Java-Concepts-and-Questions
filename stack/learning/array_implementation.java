package stack.learning;
public class array_implementation {
    // stack implementation using array
    class stack{
        int size=1000;
        int arr[] = new int [size];
        int top = -1;
        void push(int a){
            if(top==size-1){
                System.out.println("stack overflow");
            }
            else{
                top++;
                arr[top] = a;
            }
        }
        int pop(){
            if(top==-1){
                System.out.println("stack underflow");
            }
            int x=arr[top];
            top--;
            return x;
        }
        int peek(){
            if(top==-1){
                System.out.println("stack underflow");
            }
            return arr[top];
        }
        int size(){
            return top+1;
        }
    }
}
