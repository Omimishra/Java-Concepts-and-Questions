package doubly_ll;
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
        node backious = curr.back;
        backious.next = null;
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
    public node deleteNode(node head, int x) {
        // If the position to delete is the head node
        if (x == 1) {
            if (head == null || head.next == null) {
                return null; // If the list is empty or has only one node, return null
            }
            node newhead = head.next;
            newhead.back = null;
            head.next = null;
            return newhead;
        }
        node current = head;
        for (int i = 1; i < x; i++) {
            current = current.next;
        }
        // If the node to delete is the tail node
        if (current.next == null) {
            node temp = current.back;
            temp.next = null;
            current.back = null;
            return head;
        }
        // If the node to delete is in the middle
        node previous = current.back;
        node after = current.next;
        previous.next = after;
        after.back = previous;
        return head;
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
