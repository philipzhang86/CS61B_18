public class ArrayDeque<T> {
    public T[] items;
    public int size;
    public int front;
    public int tail;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        front = 0;
        tail = 1;
        size = 0;
    }

    private int addOne(int a) { //正常往后加
        return (a + 1) % items.length;
    }

    private int subOne(int a) {
        return (a - 1 + items.length) % items.length;// 0前面再加 即刻变成index7   //不断往前加
        //7-1+8=>14 % 8 =>6 再往前就 下一个index为6
    }

    public void resize(int length) {
        T[] newItems = (T[]) new Object[length];
        int oldIndex = addOne(front);
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        //原数组0~7复制到长度为16的新数组，那么新数组的头就是index15
        front = items.length - 1;
        tail = size;//新数组的尾就从index 8开始，因为0~7已经有元素了
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[front] = item;
        front = subOne(front);
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[tail] = item;
        tail = addOne(tail);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        //addFirst加完之后，front 指针已经走到items.length-1,所以要往前移一格
        int i = addOne(front);
        for (int j = 0; j < size; j++) {
            System.out.print(items[i] + " ");
            i = addOne(i);//print完之后继续指针移到下一个格
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T a = items[addOne(front)];
        items[addOne(front)] = null;
        front = addOne(front);
        size--;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T a = items[subOne(tail)];
        items[subOne(tail)] = null;
        tail = subOne(tail);
        size--;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }


    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int start = addOne(front);
        return items[(start + index) % items.length];
    }
}
