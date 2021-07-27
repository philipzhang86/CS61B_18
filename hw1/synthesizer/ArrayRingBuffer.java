package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    private final T[] items;
    private int front;
    private int tail;

    public ArrayRingBuffer(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.capacity = capacity;
        front = tail = fillCount = 0;
    }

    @Override
    public void enqueue(T element) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        items[tail++] = element;
        if (tail == capacity) {
            tail = 0;
        }
        fillCount++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T temp = items[front++];
        if (front == items.length) {
            front = 0;
        }
        fillCount--;

        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return items[front];
    }


    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }

    private class BufferIterator implements Iterator<T> {
        private int pos;

        public BufferIterator() {
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < capacity;
        }

        @Override
        public T next() {
            return items[pos++];
        }
    }
}
