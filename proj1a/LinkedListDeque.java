public class LinkedListDeque<T> {
    private StuffNode front;
    private StuffNode tail;
    private int size;

    public LinkedListDeque() {
        front = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return front == null;
    }


    public void addFirst(T x) {
        StuffNode newNode = new StuffNode(x);
        if (x == null) {
            return;
        }

        if (front == null) {
            front = tail = newNode;
        } else {
            newNode.next = front;
            front.pre = newNode;
            front = newNode;
        }
        size++;
    }

    public void addLast(T x) {
        StuffNode newNode = new StuffNode(x);
        if (x == null) {
            return;
        }
        if (tail == null) {
            tail = front = newNode;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
        size++;
    }

    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        StuffNode temp = front;

        while (temp != null) {
            if (temp.next == null) {
                System.out.print(temp.item);
            } else {
                System.out.print(temp.item + " ");
            }
            temp = temp.next;
        }
    }

    public T removeFirst() {
        if (front == null) {
            tail = null;
            return null;
        }

        StuffNode temp = front;
        if (front == tail) {
            front = tail = null;
        } else {
            front = front.next;
            front.pre = null;
        }
        size--;
        return temp.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        StuffNode temp = tail;
        if (tail == front) {
            tail = front = null;
        } else {
            tail = tail.pre;
            tail.next = null;
        }
        size--;
        return temp.item;
    }

    public T get(int index) {
        if (front == null || index > size - 1 || index < 0){
            return null;
        }
        StuffNode temp = front;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public T getRecursive(int index) {
        if (front == null || index > size - 1 || index < 0) {
            return null;
        }
        if (index == 0) {
            return front.item;
        }
        return new StuffNode(front.next.get(index - 1)).item;
    }

    private class StuffNode {
        private final T item;
        private StuffNode next;
        private StuffNode pre;

        public StuffNode(T item) {
            this.item = item;
        }

        private T get(int i) {
            if (i == 0) {
                return item;
            }
            return next.get(i - 1);
        }
    }
}
