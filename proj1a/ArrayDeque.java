public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int tail;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 4;
        tail = 5;
    }

    private void resize(int capacity) {
        T[] newCopy = (T[]) new Object[capacity];
        if (front < tail) {
            System.arraycopy(items, front + 1, newCopy, front + 1, size);
        } else {
            if (tail > 0) {
                System.arraycopy(items, 0, newCopy, 0, tail);
            }
            if (front < items.length - 1) {
                System.arraycopy(items, front + 1, newCopy, capacity - items.length + front + 1,
                        items.length - front - 1);
            }
            front = front + capacity - items.length;
        }
        items = newCopy;
    }

    private void halfSize(int capacity) {
        T[] newCopy = (T[]) new Object[capacity];
        if (front < tail) {
            System.arraycopy(items, front + 1, newCopy, 2, size);
            items = newCopy;
            front = 1;
            tail = size + 2;
        } else {
            if (tail > 0) {
                System.arraycopy(items, 0, newCopy, 0, tail);
            }
            if (front < items.length - 1) {
                System.arraycopy(items, front + 1, newCopy,
                        capacity - items.length + front + 1, items.length - front - 1);
            }
            front = front - items.length + capacity;
            items = newCopy;
        }
    }

    public void addLast(T element) {
        if (element == null) {
            return;
        }
        if (size + 2 == items.length) {
            resize(items.length * 2);
        }
        items[tail] = element;
        if (tail == items.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        size++;
    }

    public void addFirst(T element) {
        if (element == null) {
            return;
        }
        if (size + 2 == items.length) {
            resize(items.length * 2);
        }
        items[front] = element;

        if (front == 0) {
            front = items.length - 1;
        } else {
            front--;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        if (items.length >= 16 && size * 4 == items.length) {
            halfSize(items.length / 2);
        }
        if (isEmpty()) {
            return null;
        }
        if (front == items.length - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        T temp = items[front];
        items[front] = null;
        size--;

        return temp;
    }

    public T removeLast() {
        if (items.length >= 16 && size * 4 == items.length) {
            halfSize(items.length / 2);
        }
        if (isEmpty()) {
            return null;
        }

        if (tail == 0) {
            tail = items.length - 1;
        } else {
            tail--;
        }
        size--;
        T temp = items[tail]; //指针已经减了，所以才会不用再减
        items[tail] = null;
        return temp;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return items[(front + 1 + index) % items.length];
        }
        return null;
    }

    public void printDeque() {

        if (front < tail) {
            int c = front + 1;
            while (!(c == tail)) {
                System.out.print(items[c] + " ");
                c = c + 1;
            }
        } else {
            if (front < items.length - 1) {
                int c = front + 1;
                while (!(c == items.length)) {
                    System.out.print(items[c] + " ");
                    c = c + 1;
                }
            }
            if (tail > 0) {
                int c = 0;
                while (!(c == tail)) {
                    System.out.print(items[c] + " ");
                    c = c + 1;
                }
            }
        }
    }
}
