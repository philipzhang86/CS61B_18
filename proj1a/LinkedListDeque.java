import java.util.ArrayList;
import java.util.List;

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

    public StuffNode getFront() {
        return front;
    }

    public StuffNode getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean nodeIsNull(StuffNode newNode) {
        return newNode == null;
    }

    public void addFirst(T x) {
        StuffNode newNode = new StuffNode(x);
        if (nodeIsNull(newNode)) {
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
        if (nodeIsNull(newNode)) {
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
            if (nodeIsNull(temp.next)) {
                System.out.print(temp.item);
            } else {
                System.out.print(temp.item + " ");
            }
            temp = temp.next;
        }
    }

    public StuffNode removeFirst(){
        if(nodeIsNull(front)) {
            tail = null;
            return null;
        }

        StuffNode temp=front;
        if(front==tail){
            front=tail=null;
        }
        else {
            front=front.next;
            front.pre=null;
        }
        size--;
        return temp;
    }

    public StuffNode removeLast() {
        if(isEmpty()) {
            return null;
        }

        StuffNode temp=tail;
        if(tail==front){
            tail=front=null;
        }
        else {
            tail=tail.pre;
            tail.next=null;
        }
        size--;
        return temp;
    }

    public StuffNode get(int index) {
        if (nodeIsNull(front) || index > size - 1 || index < 0) {
            return null;
        }
        List<StuffNode> elements = new ArrayList<>();
        StuffNode temp = front;
        int i = 0;
        while (temp != null) {
            elements.add(temp);
            temp = temp.next;
            i++;
        }
        return elements.get(index);
    }

    public StuffNode getRecursive(int index) {
        if (nodeIsNull(front) || index > size - 1 || index < 0) {
            return null;
        }
        if (index == 0) {
            return front;
        }
        return new StuffNode(front.next.get(index - 1));
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
