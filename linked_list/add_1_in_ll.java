public class add_1_in_ll {
    class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public node reverse(node head){
        if(head==null||head.next==null)
        return head;
        node newhead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
    public node addOne(node head){ //we will reverse the linked list, add 1 to the first node and then reverse it again
        head = reverse(head);
        node current = head;
        int carry = 1;
        while(current!=null){
            current.data = current.data + carry;
            if(current.data<10){
                carry = 0;
                break;
            }
            else{
                current.data=0;
                carry = 1;
            }
            current = current.next;
        }
        if(carry==1){
            node newnode= new node(1);
            head=reverse(head);
            newnode.next=head;
            return newnode;
        }
        return reverse(head);
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
        add_1_in_ll list = new add_1_in_ll();
        node head = list.new node(1);
        head.next = list.new node(9);
        head.next.next = list.new node(9);
        System.out.println("Original list: ");
        printLinkedList(head);
        head = list.addOne(head);
        System.out.println("List after adding 1: ");
        printLinkedList(head);
    }
}
