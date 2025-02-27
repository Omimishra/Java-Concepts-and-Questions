public class deletion {
    static class node{
        int data ;
        node next;

        node(int data){
            this.data = data;
            this.next= null;
        }
    }

    public static node deleteTail(node head){
        if(head==null||head.next==null){
            return null;
        }
        node curr=head;
        while(curr.next.next!=null){
            curr=curr.next;
        }
        curr.next=null;
        return head;
    }

    public static node deleteHead(node head){
        if(head==null){
            return null;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 3, 8, 2, 3};
        node head = new node(arr[0]);
        node temp = head;
        for(int i =1;i<arr.length;i++){
            temp.next=new node(arr[i]);
            temp=temp.next;
        }
        head=deleteTail(head);
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.print("null");
    }
}
