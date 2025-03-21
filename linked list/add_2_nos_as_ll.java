public class add_2_nos_as_ll {
    // Source: https://leetcode.com/problems/add-two-numbers/
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(); 
            ListNode temp = dummy; 
            int carry = 0;
            while( l1 != null || l2 != null || carry == 1) {
                int sum = 0; 
                if(l1 != null) {
                    sum += l1.val; 
                    l1 = l1.next; 
                }
                
                if(l2 != null) {
                    sum += l2.val; 
                    l2 = l2.next; 
                }
                
                sum += carry; 
                carry = sum / 10; 
                ListNode node = new ListNode(sum % 10); 
                temp.next = node; 
                temp = temp.next; 
            }
            return dummy.next;
        }
        public static void main(String[] args) {
            add_2_nos_as_ll obj = new add_2_nos_as_ll();
            ListNode l1 = obj.new ListNode(2);
            l1.next = obj.new ListNode(4);
            l1.next.next = obj.new ListNode(3);
            ListNode l2 = obj.new ListNode(5);
            l2.next = obj.new ListNode(6);
            l2.next.next = obj.new ListNode(4);
            ListNode res = obj.addTwoNumbers(l1, l2);
            while(res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
            
        }
    }

