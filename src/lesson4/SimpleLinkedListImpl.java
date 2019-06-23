package lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    Entry<E> first;
    protected int size = 0;

    @Override
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);
        entry.setNext(first);
        if (!isEmpty()) {
            first.setPrevious(entry);
        }
        first = entry;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = first.getValue();
        first = first.getNext();
        size--;
        if (!isEmpty()) {
            first.setPrevious(null);
        }
        return value;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> entry = findEntryByValue(value);
        if (entry == null) {
            return false;
        }
        Entry<E> previous = entry.getPrevious();
        if (previous == null) {
            first = entry.getNext();
        } else {
            previous.setNext(entry.getNext());
        }
        Entry<E> next = entry.getNext();
        if (next != null) {
            next.setPrevious(entry.getPrevious());
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        return findEntryByValue(value) != null;
    }

    Entry<E> findEntryByValue(E value) {
        Entry<E> current = first;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Entry<E> current = first;
        while (current != null) {
            System.out.printf("%-4s", current.getValue().toString());
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public E getFirstValue() {
        if (first == null) {
            return null;
        }
        return first.getValue();
    }

    @Override
    public Entry getFirst() {
        return first;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }

    @SuppressWarnings("unchecked")
    private static class LinkedListIterator<E> implements ListIterator<E> {

        private SimpleLinkedListImpl list;
        private Entry<E> current;
        private Entry<E> previous;

        LinkedListIterator(SimpleLinkedListImpl list) {
            this.list = list;
            reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E nextValue = current.getValue();
            previous = current;
            current = current.getNext();
            return nextValue;
        }

        @Override
        public void reset() {
            current = list.first;
            previous = null;
        }

        @Override
        public void insertBefore(E value) {
            if (previous == null) {
                list.insertFirst(value);
                reset();
            }
            else {
                Entry newItem = new Entry(value);
                newItem.setNext(current);
                newItem.setPrevious(previous);
                previous.setNext(newItem);
                current.setPrevious(newItem);

                current = newItem;
            }
        }

        @Override
        public void insertAfter(E value) {
            if (list.isEmpty()){
                list.insertFirst(value);
                reset();
            } else {
                Entry newItem = new Entry(value);
                Entry next = current.getNext();
                newItem.setNext(next);
                newItem.setPrevious(current);
                current.setNext(newItem);
                if (next != null) {
                    next.setPrevious(newItem);
                }
                next();
            }
        }
    }
}
