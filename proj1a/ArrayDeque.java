public class ArrayDeque<T> {
    private int capacity = 8;
    private int size;
    private int front;
    private int tail;
    private T[] items;


    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return tail == front && capacity <= 8;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(items, 0, newArray, 0, size);
        items = newArray;
        capacity = newCapacity;
    }

    public void addFirst(T n) {
        if (n == null) {
            return;
        }
        items[front = (front - 1) & (items.length - 1)] = n;

        if (front == tail) {
            doubleCapacity();
        }
        size++;
    }

    public void addLast(T n) {
        if (n == null) {
            return;
        }

        items[tail] = n;

        if ((tail = (tail + 1) & (items.length - 1)) == front) {
            doubleCapacity();
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("Deque is empty, you can't remove elements");
            return null;
        }
        T result = items[front];
        items[front] = null;
        front = (front + 1) & (items.length - 1);
        size--;
        if (isLowUsageRate()) {
            resize((int) (capacity * 0.5));
        }
        return result;
    }

    public T removeLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty, you can't remove elements");
            return null;
        }
        int t = (tail - 1) & (items.length - 1);
        T result = items[t];
        items[t] = null;
        tail = t;
        size--;
        if (isLowUsageRate()) {
            resize((int) (capacity * 0.5));
        }
        return result;
    }

    public T get(int index) {
        return items[index];
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            return;
        }

        if (front < tail) {
            for (int i = 0; i != tail; i++) {
                System.out.print(items[i] + " ");
            }
        }

        if (front > tail) {
            for (int i = front; i <= items.length - 1; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < tail; i++) {
                System.out.print(items[i] + " ");
            }
        }
    }

    private void doubleCapacity() {
        assert front == tail;
        int p = front;
        int n = items.length;
        int r = n - p;
        int newCapacity = n * 2;

        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(items, p, newArray, 0, r);
        System.arraycopy(items, 0, newArray, r, p);
        items = newArray;
        front = 0;
        tail = n;
        capacity = newCapacity;
    }

    private boolean isLowUsageRate() {
        return capacity >= 16 && size() / (double) capacity < 0.25;
    }
}
