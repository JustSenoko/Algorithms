package lesson3.stack;

public interface Stack<E> {
    void push(E value);
    E pull();
    E peek();

    int size();
    boolean isEmpty();
    boolean isFull();
}
