// Source: https://leetcode.com/problems/odd-even-linked-list/
class node{
    int data;
    node next;
    node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
public class odd_even_indices {
    public node oddEvenList(node head) {
        if(head==null||head.next==null)
        return head;
        node odd = head;
        node even = head.next;
        node evenhead=even;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
    }
    odd.next=evenhead;
    return head;
}
public static void printLinkedList(node head) {
    node currNode = head;
    while (currNode != null) {
        System.out.print(currNode.data + " -> ");
        currNode = currNode.next;
    }
    System.out.println("null");

}
public static void main(String[] args) {
    odd_even_indices obj = new odd_even_indices();
    node head = new node(10);
    head.next = new node(20);
    head.next.next = new node(5);
    head.next.next.next = new node(8);
    head.next.next.next.next = new node(9);
    head.next.next.next.next.next = new node(4);
    head.next.next.next.next.next.next = new node(1);
    System.out.println("Original Linked list:");
    printLinkedList(head);
    head = obj.oddEvenList(head);
    System.out.println("Linked list after segregating odd and even indices:");
    printLinkedList(head);

}
}