import java.util.LinkedList;

public class Linked_List_jcf {
    public static void main(String args[]) {
        LinkedList<Integer> LL = new LinkedList<>();
        LL.addFirst(0);
        LL.addLast(1);
        LL.addLast(2);
        System.out.println(LL);
        LL.removeLast();
        LL.removeFirst();
        System.out.println(LL);
    }
}
