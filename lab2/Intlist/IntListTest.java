import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntListTest {

    /**
     * Example test that verifies correctness of the IntList.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.of(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList L = IntList.of(1, 2, 3);
        IntList.dSquareList(L);
        assertEquals(IntList.of(1, 4, 9), L);
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.of method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty of, which
     * can be instantiated, for example, with
     * IntList empty = IntList.of().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        IntList L = IntList.of(1, 2, 3);
        IntList res = IntList.squareListRecursive(L);
        assertEquals(IntList.of(1, 2, 3), L);
        assertEquals(IntList.of(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.dcatenate(A, B));
        assertEquals(IntList.of(1, 2, 3, 4, 5, 6), A);
        System.out.println(A);
    }

    @Test
    public void testCatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        IntList C=IntList.catenate(A,B); //= (1, 2, 3, 4, 5, 6)
        assertEquals(exp, IntList.catenate(A, B));
        assertEquals(IntList.of(1, 2, 3), A);



    }

    @Test
    public void test1(){
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);

        while (A !=null){
            System.out.println(A.first);
            A=A.rest;
        }
        while (B !=null){
            System.out.println(B.first);
            B=B.rest;
        }


    }

    @Test
    public void test3(){
        IntList A = IntList.of(3,2,1);
        IntList B = IntList.of(6, 5, 4);
        IntList exp = IntList.of(6,5,4,3,2,1);
        IntList C=IntList.catenate(B,A);
       // System.out.println(C.size());
//        while (C !=null){
//            System.out.println(C.first);
//            C=C.rest;
//        }
        Assert.assertEquals(exp,C);
    }

    @Test
    public void test4(){
//        IntList A = new IntList(30,null);
//        A=new IntList(20,A);
//        A=new IntList(10,A);
//
//        IntList B = new IntList(60,null);
//        B=new IntList(50,B);
//        B=new IntList(40,A);

        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList c=A;
        System.out.println("c was assigned by A = "+c);
        while (c.rest!=null){
            c=c.rest;
        }
        System.out.println("after loop c = "+c);
        c.rest=B;
        System.out.println(c);
        System.out.println(A);
    }
}
