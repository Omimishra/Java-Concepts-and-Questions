package doubly_ll;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class find_target_pairs {
    class node{
        int data;
        node next;
        node prev;
        node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, node head) {
        // using arraylist and hashmap
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        while(head!=null){
            int rem=target-head.data;
            if(map.containsKey(rem)){
                ArrayList <Integer> ls = new ArrayList<>();
                ls.add(rem);
                ls.add(head.data);
                list.add(ls);
            }
            else{
                map.put(head.data,0);
            }
            head= head.next;
        }
        Collections.reverse(list);
        return list;
    }
    public void find_pairs(node head, int target){
        node left = head;
        node right = head;
        while(right.next!=null){
            right = right.next;
        }
        while(left!=right && right.next!=left){
            if(left.data + right.data == target){
                System.out.println("Pair found: (" + left.data + ", " + right.data + ")");
                return;
            }else if(left.data + right.data < target){
                left = left.next;
            }else{
                right = right.prev;
            }
        }
        System.out.println("No pair found");
    
}
public static void main(String[] args) {
    find_target_pairs obj = new find_target_pairs();
    node head = obj.new node(1);
    head.next = obj.new node(2);
    head.next.prev = head;
    head.next.next = obj.new node(3);
    head.next.next.prev = head.next;
    head.next.next.next = obj.new node(4);
    head.next.next.next.prev = head.next.next;
    head.next.next.next.next = obj.new node(5);
    head.next.next.next.next.prev = head.next.next.next;
    obj.find_pairs(head, 7);

}
}