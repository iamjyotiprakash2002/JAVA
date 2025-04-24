import java.util.ArrayList;

public class ImplementStackUsing_ArrayList {
    static class Stack {
        static ArrayList<Integer> Alist = new ArrayList<>();

        public static boolean isEmpty() {
            return Alist.size() == 0;
        }

        // STEP-1--->> PUSH OPERATION T.C= O(1)
        public void push(int data) {
            Alist.add(data);
        }

        // STEP-2--->> POP OPERATION T.C= O(1)
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = Alist.get(Alist.size() - 1);
            Alist.remove(Alist.size() - 1);
            return top;
        }

        // STEP-2--->> PEEK OPERATION T.C=0(1)
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return Alist.get(Alist.size() - 1);
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!Stack.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}