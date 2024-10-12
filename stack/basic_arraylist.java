package stack;

import java.util.*;

import stack.basic_ll.stack;

public class basic_arraylist {
    static class Stack {
       static  ArrayList<Integer> list = new ArrayList<>();
        public static boolean isempty(){
            return list.size() ==0;
        }
public static void push(int data){
    list.add(data);

}
public static int pop(){
    if (isempty()){
        return -1;
    }
    int top = list.get(list.size()-1);
    list.remove(list.size()-1);
    return top;
}
public static int peek(){
    if (isempty()){
        return -1;
    }
    return list.get(list.size()-1);
}
    }

 @SuppressWarnings("unused")
public static void main(String[] args) {
        stack s = new stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isempty()) {
            System.out.println(stack.peek());
            stack.pop();

        }
}
}
