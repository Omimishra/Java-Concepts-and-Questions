package linked_list;
public class sort012inLL {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node segregate(Node head) {
        if(head==null||head.next==null)
        return head;
        
        int count_0=0;
        int count_1=0;
        Node current = head;
        while(current!=null){
            if(current.data==0) count_0++;
            else if(current.data==1) count_1++;
            current=current.next;
        }
        current=head;
        while(current!=null){
            if(count_0>0)
            {current.data=0;
            count_0--;}
            else if(count_1>0)
            {current.data=1;
            count_1--;}
            else
            {current.data=2;}
            current=current.next;
        }
        return head;
    }
    static Node segregate_in_one_pass(Node head){
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);
        Node zero_head = zero;
        Node one_head = one;
        Node two_head = two;
        Node current = head;
        while(current!=null){
            if(current.data==0) {
                zero.next=current;
                zero=zero.next;
            }
            else if(current.data==1) {
                one.next=current;
                one=one.next;
            }
            else{
                two.next=current;
                two=two.next;
            }
            current=current.next;
        }
        // Properly terminate the last node in the two list
        two.next = null;

        if(one_head.next!=null)
        {//adding one ll to zero ll
            zero.next=one_head.next;
        }
        else{
            zero.next=two_head.next;
        }
        if(two_head.next!=null)
        {//adding two ll to one ll
            one.next=two_head.next;
        }
        else{
            one.next=null;
        }
        
        head=zero_head.next;
        return head;
    }
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);
        System.out.println("Original list: ");
        printLinkedList(head);
        Node newHead = segregate_in_one_pass(head);
        System.out.println("After segregation: ");
        printLinkedList(newHead);
    }
}
