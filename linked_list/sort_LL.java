public class sort_LL {
static class Node {
    int data;
    Node next;
    Node(int data1) {
        data = data1;
        next = null;
    }
}
// Function to merge two sorted linked lists
static Node mergeTwoSortedLinkedLists(Node left, Node right) {
    Node dummyNode = new Node(-1);
    Node temp = dummyNode;
    while (left != null && right != null) {
        // Compare elements of both lists and
        // link the smaller node to the merged list
        if (left.data <= right.data) {
            temp.next = left;
            left = left.next;
        } else {
            temp.next = right;
            right = right.next;
        }
        temp = temp.next; 
    }
    // If any list still has remaining
    // elements, append them to the merged list
    if (left != null) {
        temp.next = left;
        left = left.next;
    } else {
        temp.next = right;
        right = right.next;
    }
    return dummyNode.next;
}

// Function to find the middle of a linked list
static Node findMiddle(Node head){
    if (head == null || head.next == null) {
        return head;
    }
    Node slow = head;
    Node fast = head.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

// Function to perform merge sort on a linked list
static Node sortLL(Node head){
    // Base case: if the list is empty or
    // has only one node, it is already
    // sorted, so return the head
    if (head == null || head.next == null) {
        return head;
    }
    
    // Find the middle of the list
    // using the findMiddle function
    Node middle = findMiddle(head);
    
    // Divide the list into two halves
    Node right = middle.next;
    middle.next = null;
    Node left = head;
    
    // Recursively sort the left and right halves
    left = sortLL(left);
    right = sortLL(right);
    return mergeTwoSortedLinkedLists(left, right);
}
static void printLinkedList(Node head) {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.data + " "); 
        temp = temp.next; 
    }
    System.out.println();
}

public static void main(String[] args) {
    // Linked List: 3 2 5 4 1
    Node head = new Node(3);
    head.next = new Node(2);
    head.next.next = new Node(5);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(1);

    System.out.print("Original Linked List: ");
    printLinkedList(head);

    // Sort the linked list
    head = sortLL(head);

    System.out.print("Sorted Linked List: ");
    printLinkedList(head);
}

                                
                            
}
