package stack;

import java.util.HashMap;
    class Node{
	int key;
	int val;
	Node next;
	Node prev;
	int freq=1;
	Node(int k,int v){
		key=k;
		val=v;
	}
}
class DoublyLinkedList{
	Node head;
	Node tail;
	DoublyLinkedList(){
		head=new Node(-1,-1);
		tail=new Node(-1,-1);
		head.next=tail;
		tail.prev=head;
	}
	void addNode(Node v){
		Node next=head.next;
		head.next=v;
		v.prev=head;
		head.next=v;
		v.next=next;
		next.prev=v;
	}
	Node removeNode(){
		Node node=tail.prev;
		node.prev.next=tail;
		tail.prev=node.prev;
		return node;
	}
	Node removeNode(Node v){
		Node prev=v.prev;
		Node next=v.next;
		prev.next=next;
		next.prev=prev;
		return v;
	}
	boolean isEmpty(){
		if(head.next==tail)
			return true;
		return false;
	}
}
class LFU_cache {
	// This is a LFU (Least Frequently Used) Cache implementation
HashMap<Integer,DoublyLinkedList> freqList=new HashMap<Integer,DoublyLinkedList>();
	HashMap<Integer,Node> lfuCache =new HashMap<Integer,Node>(); 
	// This is a HashMap to store the key and its corresponding node

	int capacity;
	int minFreq;
    public LFU_cache(int capacity) {
        this.capacity=capacity;
        minFreq=1;
    }
    
    public int get(int key) {
		// This method retrieves the value of the key if the key exists in the cache
		// Otherwise, it returns -1

        if(lfuCache.get(key)==null)
        	return -1;
       	Node v=lfuCache.get(key);
       	freqList.get(v.freq).removeNode(v);
       	if(freqList.get(v.freq).isEmpty()){
       		if(minFreq==v.freq){
                minFreq=v.freq+1;
            }
            	}
       	v.freq+=1;
		// Update the frequency of the node
       	if(freqList.get(v.freq)==null){
       		DoublyLinkedList d=new DoublyLinkedList();
       		d.addNode(v);
       		freqList.put(v.freq,d);
       	}
		// If the frequency list for the new frequency doesn't exist, create it

       	else{
       		freqList.get(v.freq).addNode(v);
       	}
       	return v.val;
    }
    
    public void put(int key, int value) {
         if(capacity==0)
            return;
	// This method adds a new key-value pair to the cache
	// If the key already exists, update its value and frequency
	// If the cache reaches its capacity, evict the least frequently used key
	// If the key is not found, add it to the cache
	// If the key is found, update its value and frequency
        if(lfuCache.get(key)!=null){
        	Node v=lfuCache.get(key);
        	freqList.get(v.freq).removeNode(v);
        	if(freqList.get(v.freq).isEmpty()){
                if(minFreq==v.freq)
        		minFreq=v.freq+1;
        	}
	       	v.freq+=1;
	       	if(freqList.get(v.freq)==null){
	       		 DoublyLinkedList d=new DoublyLinkedList();
	       		d.addNode(v);
	       		freqList.put(v.freq,d);
	       	}
	       	else{
	       		freqList.get(v.freq).addNode(v);
	       	}
	       	v.val=value;
	      }
	      else{
	     		if(lfuCache.size()==capacity){
	     			Node v=freqList.get(minFreq).removeNode();
	     			lfuCache.remove(v.key);			
	     		}
	     		Node newNode = new Node(key,value);
	     		lfuCache.put(key,newNode);
	     		if(freqList.get(1)!=null){
	     			freqList.get(1).addNode(newNode);
	     		}
	     		else{
	     			DoublyLinkedList d=new DoublyLinkedList();
	     			d.addNode(newNode);
	     			freqList.put(1,d);
	     		}
               minFreq=1;
	      }
    }

// Your LFUCache object will be instantiated and called as such:
// LFUCache obj = new LFUCache(capacity);
// int param_1 = obj.get(key);
// obj.put(key,value);
    public static void main(String[] args) {
        LFU_cache lfuCache = new LFU_cache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1)); // returns 1
        lfuCache.put(3, 3); // evicts key 2
        System.out.println(lfuCache.get(2)); // returns -1 (not found)
        lfuCache.put(4, 4); // evicts key 1
        System.out.println(lfuCache.get(1)); // returns -1 (not found)
        System.out.println(lfuCache.get(3)); // returns 3
        System.out.println(lfuCache.get(4)); // returns 4
    }

}