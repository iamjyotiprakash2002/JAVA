public class CircularQueue {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 & front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // ADD

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue Is Full..!!");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // REMOVE

        public static int remove() {
            if (isFull()) {
                System.out.println("Queue Is Empty..!!");
                return -1;
            }
            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // PEEK

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue Is Empty..!!");
                return -1;
            }
            return arr[front];
        }

        public static void main(String[] args) {
            Queue q = new Queue(5);
            q.add(1);
            q.add(2);
            q.add(3);
            System.out.println(q.remove());
            q.add(4);
            System.out.println(q.remove());
            q.add(5);
            q.add(6);
            while (!q.isEmpty()) {
                System.out.println(q.remove());
            }
        }
    }

}
