package synthesizer;

public interface BoundedQueue<T> extends Iterable<T> {
    int capacity();//has a fixed capacity

    int fillCount();// nothing is allowed to enqueue if the queue is full

    //items can only be enqueued at the back of the queue,
    void enqueue(T x);// addTail

    //can only be dequeued from the front of the queue.
    T dequeue(); //removeFirst

    T peek();

    default boolean isEmpty() {
        return capacity() == 0;
    }

    default boolean isFull() {
        return capacity() == fillCount();
    }
}
