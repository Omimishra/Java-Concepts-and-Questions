package stack.learning;
public class array_implementation {
    public static void main(String[] args) {
    
        stack s = new stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.peek());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.peek());
    }
    }
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
