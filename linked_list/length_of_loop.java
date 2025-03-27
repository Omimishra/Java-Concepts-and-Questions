class node{
    int data;
    node next;
    public node(int data){
        this.data=data;
        this.next=null;
}
}
public class length_of_loop {
public static int length(node head){
    node slow=head;
    node fast=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            //count is 1 and fast is inc first to count that node on which slow and fast meet
            int count=1;
            slow=slow.next;
            while(slow!=fast){
                slow=slow.next;
                count++;
            }
            return count;
        }
    }
    return 0;
}
public static void main(String[] args) {
    node head = new node(1);
        node second = new node(2);
        node third = new node(3);
        node fourth = new node(4);
        node fifth = new node(5);

        // Create a loop from fifth to second
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // This creates a loop
        fifth.next = second; 

        int loopLength = length(head);
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }
}
}
