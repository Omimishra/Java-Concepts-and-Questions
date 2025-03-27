
public class basic {
    node head;
    static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }

    }
//constructing linked list using array
    static node constructLL(int arr[]) {
        if (arr.length == 0) {
            return null;
        }
        node head = new node(arr[0]);
        node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        // for(int i =0;i<arr.length;i++){
        // node n = new node(arr[i]);
        // System.out.print(n.data+"->");
        // }
        node head = constructLL(arr);
        node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
