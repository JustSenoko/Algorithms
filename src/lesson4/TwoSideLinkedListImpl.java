package lesson4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {
    private Entry<E> last;

    @Override
    public void insertLast(E value) {
        Entry<E> entry = new Entry<>(value);
        if (isEmpty()) {
            first = entry;
        } else {
            entry.setPrevious(last);
            last.setNext(entry);
        }
        last = entry;

        size++;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E value = last.getValue();
        last = last.getPrevious();
        size--;

        if (isEmpty()) {
            first = null;
        } else {
            last.setNext(null);
        }
        return value;
    }

    @Override
    public E getLastValue() {
        if (last == null) {
            return null;
        }
        return last.getValue();
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public E removeFirst() {
        E value = super.removeFirst();
        if (isEmpty()) {
            last = null;
        }
        return value;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> entry = findEntryByValue(value);
        if (entry == null) {
            return false;
        }
        if (entry.equals(first)) {
            removeFirst();
        } else if (entry.equals(last)) {
            removeLast();
        } else {
            entry.getPrevious().setNext(entry.getNext());
            entry.getNext().setPrevious(entry.getPrevious());
            size--;
        }
        return true;
    }
}
