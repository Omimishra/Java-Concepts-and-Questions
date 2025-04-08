package hard;
// Source: https://www.geeksforgeeks.org/rotate-a-linked-list/
class Node {
  int num;
  Node next;

  Node(int a) {
    this.num = a;
    this.next = null;
  }
}

class rotate_ll {
  // utility function to insert node at the end of the list
  static Node insertNode(Node head, int val) {
    Node newNode = new Node(val);
    if (head == null) {
      head = newNode;
      return head;
    }
    Node temp = head;
    while (temp.next != null)
      temp = temp.next;

    temp.next = newNode;
    return head;
  }

  static Node findNthNode(Node head, int n) {
    Node temp = head;
    int cnt = 1;
    while (temp != null) {
      if (cnt == n)
        return temp;
      cnt++;
      temp = temp.next;
    }
    return temp;
  }

  // utility function to rotate list by k times
  static Node rotateRight(Node head, int k) {
    if (head == null || head.next == null)
      return head;
    Node tail = head;
    int len = 1;
    while (tail.next != null) {
      tail = tail.next;
      len++;
    }
    if (k % len == 0)
      return head; // if k is multiple of len, no rotation needed
    k = k % len; // if k is greater than len, we take mod of k with len
    tail.next = head; // linking last node to head
    Node newlastNode = findNthNode(head, len - k); // finding the new last node
    head = newlastNode.next; // updating head to new first node
    newlastNode.next = null; // breaking the link between new last node and head
    return head;
  }

  // utility function to print list
  static void printList(Node head) {
    while (head.next != null) {
      System.out.print(head.num + "->");
      head = head.next;
    }
    System.out.println(head.num);

  }

  public static void main(String args[]) {
    // rotate_ll obj = new rotate_ll();
    Node head = null;
    // inserting Node
    head = insertNode(head, 1);
    head = insertNode(head, 2);
    head = insertNode(head, 3);
    head = insertNode(head, 4);
    head = insertNode(head, 5);

    System.out.println("Original list: ");
    printList(head);
    int k = 2;
    Node newHead = rotateRight(head, k); // calling function for rotating
    // right of the nodes by k times

    System.out.println("After " + k + " iterations: ");
    printList(newHead); // list after rotating nodes

  }
}