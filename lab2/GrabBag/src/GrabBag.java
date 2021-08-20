import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GrabBag<T> implements Iterable<T> {
    private static final int INIT_CAPACITY = 8;

    public T[] array;
    public int N, front;

    public GrabBag() {
        array = (T[]) new Object[INIT_CAPACITY];
        front = N = 0;
    }

    public static void main(String[] args) {
        GrabBag<Integer> grabBag = new GrabBag<>();
        for (int i = 0; i <= 10; i++) {
            grabBag.add(i);
        }
        for (int i = 8; i >= 0; i--) {
            System.out.println("grab bag random remove = " + grabBag.remove());
        }
        grabBag.add(-1);
        grabBag.print();
        System.out.println("\ngrabBag front = " + grabBag.front);
        System.out.println("grabBag tail = " + grabBag.N);
        System.out.println("grabBag size = " + grabBag.size());
        System.out.println(Arrays.toString(grabBag.array));

        for (int i = 0; i < 10; i++) {
            System.out.println("grab bag random sample = " + grabBag.sample());
        }

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(T item) {
        if (N == array.length) resize(2 * array.length);
        array[N++] = item;
    }

    public T deleteFrontItem() {
        return deleteKthItem(0);
    }

    public T remove() {
        if (isEmpty()) throw new NoSuchElementException("Grab Bag is empty");
        int randomIndex = StdRandom.uniform(0, size());
        T item = array[randomIndex];
        deleteKthItem(randomIndex);
        return item;
    }

    private T deleteKthItem(int index) {

        T item = array[index];
        // shift all the elements from index  till rear to the left by one
        for (int i = index; i < N - 1; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }
        N--;
        if (N > 0 && N == array.length / 4) resize(array.length / 2);
        return item;
    }

    public T sample() {
        if (isEmpty()) throw new NoSuchElementException("Grab Bag is empty");
        int randomIndex = StdRandom.uniform(0, size());
        return array[randomIndex];
    }

    public void print() {
        for (T element : this) {
            System.out.print(element + " ");
        }
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public Iterator<T> iterator() {
        return new GrabBagIterator();
    }

    private class GrabBagIterator implements Iterator<T> {
        private int index = front;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[index++];
        }
    }
}
