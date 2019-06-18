package lesson3.stack;

public interface Stack<E> {
    boolean push(E value);
    E pop();
    E peek();

    int size();
    boolean isEmpty();
    boolean isFull();
}
