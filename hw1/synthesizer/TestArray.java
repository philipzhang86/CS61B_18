package synthesizer;

import org.junit.Assert;
import org.junit.Test;

public class TestArray {

    @Test
    public void testEnqueue() {
        ArrayRingBuffer<Integer> array = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            array.enqueue(i);
        }
        Assert.assertEquals(0, (long) array.dequeue());
        System.out.println(array);
        System.out.println(array.peek());
        Assert.assertEquals(1, (long) array.peek());
        Assert.assertEquals(1, (long) array.dequeue());
        Assert.assertEquals(2, (long) array.peek());
        System.out.println(array);
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Integer> array = new ArrayRingBuffer<>(100);
        for (int i = 0; i < 100; i++) {
            array.enqueue(i);
        }
        System.out.println(array);
        for (Integer i : array) {
            System.out.println(i);
        }
    }

}
