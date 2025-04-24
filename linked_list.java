//import java.util.LinkedList;

public class linked_list {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addMiddle(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void print(int data) {
        Node temp = head;
        if (head == null) {
            System.out.print("LinkedList Is Empyt...!!");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList Is Empty...!!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LinkedList Is Empty...!!");
            return Integer.MIN_VALUE;
        }

        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public void reverseLL() {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrom() {
        if (head == null || head.next == null) {
            return true;
        }

        // step-1--->> FIND THE MIDDLE;
        Node midNode = middle(head);

        // step-2-->> REVERSE SECOND HALF
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // Step-3-->> CHECK LEFT HALF AND RIGHT HALF
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true; // CYCLE FOUND.
            }
        }
        return false; // CYCLE NOT FOUND
    }

    public static void removeCycle() {
        // STEP-1-->> DETECT CYCLE
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        // STEP-2-->> FIND MEETING POINT
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // STEP-3-->> REMOVE CYCLE i.e, Last.next=null;
        prev.next = null;
    }

    public static void main(String args[]) {
        // linked_list ll = new linked_list();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.print(0);
        // System.out.println("The LinkedList Is Palindrom: " + ll.checkPalindrom());

        // FOR FLOYD'S CYCLE FINDING ALGORITHM.
        head = new Node(1);
        Node temp = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = temp;
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(4);
        // ll.print(0);
        // ll.addMiddle(2, 2);
        // System.out.println("Before Reversing The LinkedList Is:");
        // ll.print(0);
        // ll.reverseLL();
        // System.out.println("After Reversing The LinkedList Is:");
        // ll.print(0);
        // System.out.println("The Size Of The LinkedList is: " + ll.size);
        // ll.removeFirst();
        // System.out.println("After Deleting The First Node The LinkedList Is:");
        // ll.print(0);
        // System.out.println("The Size Of The LinkedList is: " + ll.size);
        // ll.removeLast();
        // System.out.println("After Deleting The Last Node The LinkedList Is:");
        // ll.print(size);
        // System.out.println("The Size Of The LinkedList is: " + ll.size);
        // System.out.println("Is The LinkedList Palindrom: " + ll.checkPalindrom());
        // System.out.println(ll.iterativeSearch(10) + " It means key doesn't Found.");
        // System.out.println("Key Found At Index no: " + ll.iterativeSearch(2));
    }
}