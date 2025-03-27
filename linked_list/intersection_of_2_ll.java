package linked_list;
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int data) {
    this.data = data;
    this.next = null;
    }
}

public class intersection_of_2_ll {
//utility function to insert node at the end of the linked list
static Node insertNode(Node head,int val) {
    Node newNode = new Node(val); 
    if(head == null) {
        head = newNode;
        return head;
    } 
    Node temp = head;
    while(temp.next != null) temp = temp.next;
    
    temp.next = newNode;
    return head;
}

//utility function to check presence of intersection
static Node intersection_hashing(Node head1,Node head2) {
     HashSet<Node> st=new HashSet<>();
    while(head1 != null) {
       st.add(head1);
       head1 = head1.next;
    }
    while(head2 != null) {
        if(st.contains(head2)) return head2;
        head2 = head2.next;
    }
    return null;

}
static Node intersection(Node head1,Node head2){
    Node temp1 = head1;
    Node temp2 = head2;
    while(temp1!=temp2){
        if(temp1==null) temp1=head2;
        temp1=temp1.next;
        if(temp2==null) temp2=head1;
        temp2=temp2.next;
    }
    return temp1;
}
//utility function to print linked list created
static void printList(Node head) {
    while(head.next != null) {
    System.out.print(head.data+"->");
        head = head.next;
    }
    System.out.println(head.data);
}

public static void main(String args[]) {
    // creation of both lists 
    Node head = null;
    head=insertNode(head,1);
    head=insertNode(head,3);
    head=insertNode(head,1);
    head=insertNode(head,2);
    head=insertNode(head,4);
    Node head1 = head;
    head = head.next.next.next;
    Node headSec = null;
    headSec=insertNode(headSec,3);
    Node head2 = headSec;
    headSec.next = head;
    //printing of the lists
    System.out.print("List1: "); printList(head1);
    System.out.print("List2: "); printList(head2);
    //checking if intersection is present
    Node answerNode = intersection(head1,head2);
    if(answerNode == null)  
    System.out.println("No intersection\n");
    else
    System.out.println("The intersection point is "+answerNode.data);
    
}
}
// Time complexity: O(n+m) where n and m are the lengths of the two linked lists
// Space complexity: O(n) where n is the length of the first linked list
