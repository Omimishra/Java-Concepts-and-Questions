public class delete_duplicates {
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    Node removeDuplicates(Node head){
        // Code Here.
        if(head==null ||head.next==null){
             return head;
         }  
         Node curr = head;
         Node temp = curr.next;
         while(curr!=null&&temp!=null){
             if(curr.data==temp.data){
                 curr.next=temp.next;
                 temp=curr.next;
                 if(temp!=null)
                 temp.prev=curr;
             }
             else{
                 curr=curr.next;
                 temp=temp.next;
             }
         }
         return head;
    }
public static void main(String[] args) {
    delete_duplicates obj = new delete_duplicates();
    Node head = obj.new Node(1);
    head.next = obj.new Node(2);
    head.next.next = obj.new Node(2);
    head.next.next.next = obj.new Node(4);
    head.next.next.next.next = obj.new Node(5);
    head.next.next.next.next.next = obj.new Node(5);
    obj.removeDuplicates(head);
    Node curr = head;
    while (curr != null) {
        System.out.print(curr.data + " ");
        curr = curr.next;
    }
    System.out.println();
}
}
