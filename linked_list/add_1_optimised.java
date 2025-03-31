public class add_1_optimised {
    class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public node check_carry(node head){
        int carry = add_one(head);
        if(carry==1){
            node newnode = new node(1);
            newnode.next = head;
            return newnode;
        }
        return head;
    }
    public int add_one(node temp){
        if(temp==null)
        return 1;
        int carry = add_one(temp.next);
        temp.data = temp.data + carry;
        if(temp.data<10)
        return 0;
        temp.data=0;
        return 1;
    }
    public void printLinkedList(node head) {
        node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        add_1_optimised obj = new add_1_optimised();
        node head = obj.new node(1);
        head.next = obj.new node(9);
        head.next.next = obj.new node(9);
        System.out.println("Original list: ");
        obj.printLinkedList(head);
        head = obj.check_carry(head);
        System.out.println("List after adding 1: ");
        obj.printLinkedList(head);
    }
}
