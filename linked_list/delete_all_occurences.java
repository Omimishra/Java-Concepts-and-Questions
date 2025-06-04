public class delete_all_occurences {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head==null){
             return null;
         }  
         if(head.next==null && head.data==x)
            return null;
       
        while(head.data==x){
            head=head.next;
        }
        Node cur=head;
        Node nex=cur.next;
        while(nex!=null){
            if(nex.data==x){
                cur.next=nex.next;
                nex=cur.next;
            }
            else{
                cur=cur.next;
                nex=nex.next;
            }
        }
        return head;
    }
    public void display(Node head){
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        delete_all_occurences obj = new delete_all_occurences();
        Node head = obj.new Node(1);
        head.next = obj.new Node(2);
        head.next.next = obj.new Node(2);
        head.next.next.next = obj.new Node(4);
        head.next.next.next.next =obj. new Node(5);
        obj.display(head);
        // deleteAllOccurOfX(head, 0);
    }
}
