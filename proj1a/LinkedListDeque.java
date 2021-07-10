import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> {
    private class StuffNode{
        private T item;
        private StuffNode next;
        private StuffNode pre;

        public StuffNode(T item) {
            this.item = item;
        }

        private T get(int i){
            if(i==0)
                return item;
            return next.get(i-1);
        }

    }

    private StuffNode front;
    private StuffNode tail;
    private int size;

    public LinkedListDeque() {
        front=tail=null;
        size=0;
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

    public boolean isEmpty(){
        return front==null;
    }

    public boolean nodeIsNull(StuffNode newNode){
        return newNode==null;
    }

    public void addFirst(T x){
        StuffNode newNode=new StuffNode(x);
        if(nodeIsNull(newNode)) {
            return;
        }

        if(front==null){
            front=tail=newNode;
        }
        else{
            newNode.next=front;
            front.pre=newNode;
            front=newNode;
        }
        size++;
    }

    public void addLast(T x){
        StuffNode newNode=new StuffNode(x);
        if(nodeIsNull(newNode)) {
            return;
        }
        if(tail==null) {
            tail = front = newNode;
        }
        else {
            tail.next=newNode;
            newNode.pre=tail;
            tail=newNode;
        }
        size++;
    }

    public void printDeque(){
        if(isEmpty())
            return;

        StuffNode temp= front;

        while (temp!=null){
            if(nodeIsNull(temp.next))
                System.out.print(temp.item);
            else
                System.out.print(temp.item+" ");
            temp=temp.next;
        }
    }

    public StuffNode removeFirst(){
        if(nodeIsNull(front)) {
            tail = null;
            return null;
        }
        StuffNode temp=front;
        front=front.next;

        if(front!=null){
            front.pre=null;
        }
        size--;
        return temp;
    }

    public StuffNode removeLast(){
        if(nodeIsNull(tail))
            return null;

        StuffNode temp=tail;
        if(tail.pre==null) {
            tail = null;
        }
        else {
            tail.pre.next=null;
            tail=tail.pre;
        }
        size--;

        return temp;
    }

    public StuffNode get(int index){
        if(nodeIsNull(front)||index>size-1||index<0)
            return null;
        List<StuffNode> elements=new ArrayList<>();
        StuffNode temp=front;
        int i=0;
        while (temp !=null){
            elements.add(temp);
            temp=temp.next;
            i++;
        }
        return elements.get(index);
    }

    public StuffNode getRecursive(int index){
        if(nodeIsNull(front)||index>size-1||index<0)
            return null;
        if(index==0)
            return front;
        return new StuffNode(front.next.get(index-1));
    }
}
