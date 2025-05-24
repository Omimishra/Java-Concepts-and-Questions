package stack;

import java.util.HashMap;
    class Node{
	int key;
	int val;
	Node next;
	Node prev;
	int frequency;
	Node(int k,int v){
		this.key=k;
		this.val=v;
		this.frequency=1; // initializing frequency to 1 when the node is created
	}
}
class DoublyLinkedList{
	int size;
	Node head;
	Node tail;
	DoublyLinkedList(){
		size=0;
		head=new Node(-1,-1);
		tail=new Node(-1,-1);
		head.next=tail;
		tail.prev=head;
	}
	void addNode(Node v){
		Node nextNode=head.next;
		v.next=nextNode;
		v.prev=head;
		head.next=v;
		nextNode.prev=v;
		size++;
	}
	void removeNode(Node v){
		Node prevnode=v.prev;
		Node nextNode=v.next;
		prevnode.next=nextNode;
		nextNode.prev=prevnode;
		size--;
	}
	
}
class LFU_cache {
	// This is a LFU (Least Frequently Used) Cache implementation
HashMap<Integer,DoublyLinkedList> freqList;
	HashMap<Integer,Node> lfuCache ;
	int capacity;
	int minFreq;
	int curSize;
    public LFU_cache(int capacity) {
        this.capacity=capacity;
		this.curSize=0;
        this.minFreq=0;
		this.freqList=new HashMap<>();
		this.lfuCache=new HashMap<>();
    }
    
    public int get(int key) {
		Node currNode = lfuCache.get(key);
		if(currNode==null)
			return -1;
			updateNode(currNode);// this means that node already exists so we need to update its value as well as inc the frequency
			return currNode.val;
       
    }
    
    public void put(int key, int value) {
         if(capacity == 0) return; // if capacity is 0, we can't add anything
		 if(lfuCache.containsKey(key)) {
			Node currNode = lfuCache.get(key);
			currNode.val = value; // update the value of the node
			updateNode(currNode); // update the frequency of the node
		 } else {
			curSize++;
			if(curSize > capacity) {
				DoublyLinkedList minFreqList = freqList.get(minFreq);
				lfuCache.remove(minFreqList.tail.prev.key); // remove the least frequently used node
				minFreqList.removeNode(minFreqList.tail.prev); // remove the node from the doubly linked list
				curSize--;
    }
	minFreq = 1; // reset the min frequency to 1
			Node newNode = new Node(key, value);
			DoublyLinkedList newList = freqList.getOrDefault(1, new DoublyLinkedList());
			newList.addNode(newNode); // add the new node to the doubly linked list
			freqList.put(1, newList); // update the frequency list
			lfuCache.put(key, newNode); // add the node to the cache
		}
	}
	
public void updateNode(Node currNode){
	int currfreq=currNode.frequency;
	DoublyLinkedList currlist=freqList.get(currfreq);
	currlist.removeNode(currNode);
	if(currlist.size==0 && currfreq==minFreq){
		minFreq++;
	}
	currNode.frequency++;
	DoublyLinkedList newList=freqList.getOrDefault(currNode.frequency,new DoublyLinkedList());
	newList.addNode(currNode);
	freqList.put(currNode.frequency,newList);
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