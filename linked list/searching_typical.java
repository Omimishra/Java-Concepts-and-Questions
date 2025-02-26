
public class searching_typical {
    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static boolean searchKey(node head, int key) {
        node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 3, 8, 2, 3};
        node head = new node(arr[0]);
        node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new node(arr[i]);
            temp = temp.next;
        }
        System.out.println(searchKey(head, 3));
    }
}
