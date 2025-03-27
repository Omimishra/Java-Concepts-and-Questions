// Source: https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
// Given a singly linked list of N nodes. The task is to find the middle of the linked list. For example, if the linked list is 1->2->3->4->5 then the middle node is 3. If there are two middle nodes, then the second middle node should be printed. For example, if the linked list is 1->2->3->4->5->6 then the middle node is 4.
public class findmiddle {
    class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static node findMiddle(node head) {
        node slow=head;
        node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        findmiddle obj = new findmiddle();
        node head = obj.new node(1);
        head.next = obj.new node(2);
        head.next.next = obj.new node(3);
        head.next.next.next = obj.new node(4);
        head.next.next.next.next = obj.new node(5);
        head.next.next.next.next.next = obj.new node(6);
        
        node mid = findMiddle(head);
        System.out.println(mid.data);
    }
}
