package lesson3.stack;

public class StackImpl<E> implements Stack<E> {
    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        this.data[size++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (size == 0) {
            return null;
        }
        return data[--size];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return data[size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
