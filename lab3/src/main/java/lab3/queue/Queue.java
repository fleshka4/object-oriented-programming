package lab3.queue;

import lab3.queue.exceptions.QueueOverflowException;
import lab3.queue.exceptions.QueueUnderflowException;

import java.util.ArrayList;

public class Queue<E> {
    private final ArrayList<E> array;
    private final int capacity;
    private int size = 0;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.array = new ArrayList<>(capacity);
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "array=" + array +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }

    public boolean add(E elem) throws QueueOverflowException {
        if (!offer(elem)) {
            throw new QueueOverflowException("Queue is full");
        }
        return true;
    }

    public boolean offer(E elem) {
        if (size == capacity) {
            return false;
        }
        array.add(size++, elem);
        return true;
    }

    public E remove() throws QueueUnderflowException {
        if (size == 0) {
            throw new QueueUnderflowException("Queue is empty");
        }
        return poll();
    }

    public E poll() {
        if (size == 0) {
            return null;
        }
        final E temp = array.get(0);
        array.remove(0);
        return temp;
    }

    public E element() throws QueueUnderflowException {
        if (size == 0) {
            throw new QueueUnderflowException("Queue is empty");
        }
        return peek();
    }

    public E peek() {
        return array.get(0);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }
}
