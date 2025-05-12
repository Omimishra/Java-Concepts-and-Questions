package queue;

public class circular_queue {
    static class queue {
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;

        @SuppressWarnings("static-access")
        queue(int size) {
            arr = new int[size];
            this.size = size;
        }

        public static boolean isEmpty() {
            // if both front and rear are -1, then queue is empty
            // if front is -1, then queue is empty
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            // if rear is equal to size-1, then queue is full
            // if front is equal to 0, then queue is full
            // if front is equal to rear+1, then queue is full
            return front == (rear + 1) % size;
        }

        public static void add(int data) {
            // if queue is full, then we cannot add any more elements
            // if rear is equal to size-1, then queue is full
            if (isFull()) {
                System.out.println("queue is full");
                return;
            }

            // 1st element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int result = arr[front];

            // single element condition
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[front];
        }

        public static void main(String[] args) {
            @SuppressWarnings("unused")
            queue q = new queue(5);
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);
            System.out.println(queue.remove());
            queue.add(6);
            System.out.println(queue.remove());
            queue.add(7);
            while (!queue.isEmpty()) {
                System.out.println(queue.peek());
                queue.remove();
            }
        }
    }
}
