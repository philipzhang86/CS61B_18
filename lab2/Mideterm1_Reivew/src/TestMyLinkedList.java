import org.junit.Test;

public class TestMyLinkedList {

    @Test
    public void test1(){
        MyLinkedList<Integer> m1=new MyLinkedList<>();
        m1.addFirst(2);
        m1.addFirst(10);
        m1.addFirst(100);
//        System.out.println(m1.first.item);
//        System.out.println(m1.first.next.item);
//        System.out.println(m1.first.next.next.item);
        //m1.printList();
        //System.out.println("\n"+m1.get(2));
        m1.addLast(1);
        m1.addLast(-1);
//        m1.printList();
//        System.out.println("\n"+m1.removeLast());
//        m1.printList();
        m1.insert(-100,0);
        m1.printList();


    }
}
