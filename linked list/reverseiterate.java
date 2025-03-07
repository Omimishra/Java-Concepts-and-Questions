
public class reverseiterate {
    Node head;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

   public Node constructLL(int arr[]){
    if (arr.length==0){
        return null;
    }
    Node head = new Node(arr[0]);
    Node temp = head;
    for (int i = 1; i < arr.length; i++) {
        temp.next = new Node(arr[i]);
        temp = temp.next;
    }
    return head;
   }

    public void printlist(Node head) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }

        System.out.println("NULL");

    }

    public Node reverselist(Node head) {

        Node prevnode = null;
        Node currNode = head;

        while (currNode != null) {
            Node nextnode = currNode.next;
            currNode.next = prevnode;

            // update
            prevnode = currNode;
            currNode = nextnode;
        }
        return prevnode;
    }

    public static void main(String[] args) {
        reverseiterate list = new reverseiterate();
        int arr[] = { 1, 2, 3, 4, 5 };
        Node head = list.constructLL(arr);
        list.printlist(head);

        head = list.reverselist(head);
        list.printlist(head);

    }
}
