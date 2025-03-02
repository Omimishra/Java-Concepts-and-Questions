public class delete_double_ll {
    class node{
        int data;
        node next;
        node back;
        node(int data){
            this.data = data;
            this.next = null;
            this.back=null;
        }
    }
    public node constructLL(int arr[]) {
        if(arr.length==0){
            return null;
        }
        node head = new node(arr[0]);
        node currNode = head;
       for(int i =1;i<arr.length;i++){
        currNode.next = new node(arr[i]);
        currNode.next.back = currNode;
        currNode = currNode.next;
       }
        return head;
    }
    public node delete_tail(node head){
        if(head==null||head.next==null){
            return null;
        }
        node curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        node previous = curr.back;
        previous.next = null;
        curr.back = null;
        return head;
    }
    public node delete_head(node head){
        if(head==null||head.next==null){
            return null;
        }

        node newHead = head.next;
        newHead.back = null;
        head.next = null;
        return newHead;
    }
    public static void main(String[] args) {
        delete_double_ll d = new delete_double_ll();
        int arr[] = {1, 2, 3, 4, 5};
        node head = d.constructLL(arr);
        // head = d.delete_tail(head);
        head = d.delete_head(head);
        node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "<->");
            currNode = currNode.next;
        }
    }
}
