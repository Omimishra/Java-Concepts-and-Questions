public class swapPairNodes {
    ListNode head;

    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
        return head;

        ListNode currnode = head.next.next;
        ListNode prev = head;
        head = head.next;
        head.next = prev;
        while(currnode != null && currnode.next != null){
            prev.next= currnode.next;
           prev = currnode;
           ListNode temp = currnode.next.next;
           currnode.next.next = currnode;
           currnode = temp;
        }
        prev.next = currnode;
        return head;
    }
}
