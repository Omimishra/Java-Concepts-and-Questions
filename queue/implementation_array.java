package queue;

public class implementation_array {
    static class queue {
        static int arr[];
        static int size;
        static int rear = -1;

        @SuppressWarnings("static-access")
        queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Full Queue");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public static int peek(){
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[0];
        }

        public static void main(String[] args) {
            @SuppressWarnings("unused")
            queue q = new queue(5);
            queue.add(1);
            queue.add(2);
            queue.add(3);

            while(!queue.isEmpty()){
                System.out.println(queue.peek());
                queue.remove();
            }
        }
    }
}
