package lesson3.deque;

import lesson3.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertRight(E value) {
        return insert(value);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head == 0) {
            head = lastIndex() + 1;
        }
        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        if (tail == -1) {
            tail = lastIndex();
        }
        size--;
        return data[tail--];
    }

    @Override
    public E removeLeft() {
        return remove();
    }

    @Override
    public E peekRight() {
        if (tail == -1) {
            return null;
        }
        return data[tail];
    }

    @Override
    public E peekLeft() {
        return peek();
    }

}
