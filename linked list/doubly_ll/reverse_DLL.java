public class reverse_DLL {
    class node{
        int data;
        node next;
        node back;
        node(int data){
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    public node constructLL(int arr[]){
        if (arr.length==0){
            return null;
        }
        node head=new node(arr[0]);
        node current = head;
        for(int i =1;i<arr.length;i++){
            current.next = new node(arr[i]);
            current.next.back=current;
            current = current.next;
        }
        return head;
    }
    public node reverse(node head){
        if(head == null || head.next == null){
            return head;
        }
        node current = head;
        node temp = null;
        while(current != null){
            temp = current.back;
            current.back = current.next;
            current.next = temp;
            current = current.back;
        }
        if(temp != null){
            head = temp.back;
        }
        return head;
    }
    public void printLL(node head){
        node current = head;
        while(current != null){
            System.out.print(current.data+"<->");
            current = current.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        reverse_DLL obj = new reverse_DLL();
        int arr[] = {1,2,3,4,5};
        node head = obj.constructLL(arr);
        head = obj.reverse(head);
        obj.printLL(head);
    }
}
