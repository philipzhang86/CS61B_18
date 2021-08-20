import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{
    Node first;
    int N;

    public class Node{
        T item;
        Node next;

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        private T get(int i){
            if(i==0) return item;
            return next.get(i-1);
        }
    }

    public void addFirst(T item){
        Node oldFirst =first;
        first =new Node(item,null);
        first.next=oldFirst;
        N++;
    }

    public T removeFirst(){
        T item =first.item;
        first=first.next;
        N--;
        return item;
    }

    public boolean isEmpty(){
        return N==0;
    }


    public void addLast(T item){
        Node temp =getLastNode();
        temp.next=new Node(item,null);
        N++;
    }

    public T removeLast(){
        T item=getLastNode().item;
        Node temp =first;
        while (temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        N--;
        return item;
    }

    private Node getLastNode(){
        Node temp =first;
        while (temp.next!=null){
            temp =temp.next;
        }
        return temp;
    }

    public void insert(T item, int index){
        if(index< 0 || index >size()){
            throw new IllegalArgumentException();
        }

        insert(item,index,first);
        N++;
    }

    public void insert(T item, int index, Node n){
        if(index==0){
            Node oldFirst=n;
            //n =new Node(item,oldFirst);
            //n.next =new Node(item,n.next);
        }else {
            insert(item,index-1,n.next);
        }
    }

    public int size(){
        return N;
    }

    public void printList(){
        for(T item:this){
            System.out.print(item+" ");
        }
    }

    public T get(int i){
        if(i==0) return first.item;
        return first.next.get(i-1);
    }

    public Iterator<T> iterator(){
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T>{
        private Node current =first;

        @Override
        public boolean hasNext(){
            return current !=null;
        }

        @Override
        public T next(){
            T item = current.item;
            current =current.next;
            return item;
        }
    }
}
