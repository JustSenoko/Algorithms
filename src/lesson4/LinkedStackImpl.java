package lesson4;

import lesson3.stack.Stack;

public class LinkedStackImpl<E> implements Stack<E> {

    private LinkedList<E> data = new SimpleLinkedListImpl<>();

    @Override
    public boolean push(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstValue();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
