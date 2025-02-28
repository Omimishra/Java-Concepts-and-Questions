public class doubleLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node head;
    static Node tail;
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    Node constructLL(int arr[]) {
        if(arr.length==0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node currNode = head;
        for (int i = 1; i < arr.length; i++) {
           currNode.next = new Node(arr[i]);
           currNode.next.prev = currNode;
           currNode = currNode.next;
        }
        return head;
    }
    public static void main(String[] args) {
        // doubleLL dll = new doubleLL();
        // int arr[] = {1, 2, 3, 4, 5};
        // Node head = dll.constructLL(arr);
        addFirst(1);
        addFirst(5);
        addLast(7);
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "<->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }
}
