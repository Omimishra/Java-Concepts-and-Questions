package linked_list.doubly_ll;
public class insert_at_given_pos {
    class Node{
        int data;
        Node next;
        Node back;
        Node(int data){
            this.data = data;
            this.next = null;
            this.back=null;
        }
    }
    public Node constructLL(int arr[]) {
        if(arr.length==0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node currNode = head;
        for (int i = 1; i < arr.length; i++) {
           currNode.next = new Node(arr[i]);
           currNode.next.back = currNode;
           currNode = currNode.next;
        }
        return head;
    }
    public Node addNode(Node head, int p, int x) {
        Node newNode = new Node(x);
        Node curr = head;
        for(int i = 0; i < p; i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;    
        newNode.back=curr;
        return head;
    }
    public static void main(String[] args) {
        insert_at_given_pos obj = new insert_at_given_pos();
        int arr[] = {1, 2, 3, 4, 5};
        Node head = obj.constructLL(arr);
        obj.addNode(head, 2, 10);
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "<->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
}
}
