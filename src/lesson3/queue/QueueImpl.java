package lesson3.queue;

public class QueueImpl<E> implements Queue<E> {

    protected E[] data;
    protected int size;

    protected int head;
    protected int tail;

    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @SuppressWarnings("unchecked")
    public E[] getDataInOrder() {
        E[] result = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            int index = head + i;
            if (index > lastIndex()) {
                index = index - lastIndex() - 1;
            }
            result[i] = data[index];
        }
        return result;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }
        if (tail == lastIndex()) {
            tail = DEFAULT_TAIL;
        }
        data[++tail] = value;
        size++;
        return true;
    }

    protected int lastIndex() {
        return data.length - 1;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        if (head > lastIndex()) {
            head = DEFAULT_HEAD;
        }
        size--;
        return data[head++];
    }

    @Override
    public E peek() {
        return data[head];
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

    public void print() {
        E[] dataInOrder = getDataInOrder();
        for (int i = 0; i < size; i++) {
            System.out.printf("%s   ", dataInOrder[i].toString());
        }
        System.out.println();
    }
}
