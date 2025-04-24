public class StackUsing_LL {
    // STEP-1
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // STEP-2

    static class Stack {
        static Node head = null;

        // STEP-3
        public static boolean isEmpty() {
            return head == null;
        }

        // STEP-4
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // STEP-5
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // STEP-6
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    // STEP-7
    public static void main(String[] args) {
        Stack ss = new Stack();
        ss.push(1);
        ss.push(2);
        ss.push(3);
        while (!Stack.isEmpty()) {
            System.out.println(ss.peek());
            ss.pop();
        }
    }
}
