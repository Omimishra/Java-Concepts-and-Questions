package queue.learning;

public class array_implement {

    public static void main(String[] args) {
        queue q = new queue();
        q.enqueue(6);
        q.enqueue(3);
        q.enqueue(7);
        System.out.println("Front of the queue before deleting any element " + q.peek());
        System.out.println("Size of the queue before deleting any element " + q.size());
        System.out.println("The element deleted is " + q.dequeue());
        System.out.println("Size of the queue after deleting an element " + q.size());
        System.out.println("Front of the queue after deleting an element " + q.peek());
    }
}
    // queue implementation using array 
   class queue {
        int front, rear, size;
        int capacity;
        int[] queueArray;
        // Constructor to initialize the queue
        public queue() {
            front = size = 0;
            rear = -1;
            capacity = 1000;
            queueArray = new int[capacity];
        }
        // Constructor to initialize the queue with a specific capacity
        // queue(int c) {
        //     front = size = 0;
        //     rear = c - 1;
        //     capacity = c;
        //     queueArray = new int[c];
        // }
        boolean isFull() {
            return (size == capacity);
        }
        boolean isEmpty() {
            return (size == 0);
        }
        void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            rear = (rear + 1) % capacity;
            queueArray[rear] = item;
            size = size + 1;
        }
        int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int item = queueArray[front];
            front = (front + 1) % capacity;
            size = size - 1;
            return item;
        }
        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return queueArray[front];
        }
        int size() {
            return size;
        }
}
