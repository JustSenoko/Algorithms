package lesson8;

import java.util.LinkedList;

public class LinkedHashTableImpl implements HashTable {

    private static class Entry {
        private Item key;
        private int value;

        Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private LinkedList<Entry>[] data;
    private int size;

    LinkedHashTableImpl(int size) {
        this.data = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            data[i] = new LinkedList<>();
        }
    }

    private int hashFunc(Item key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(Item item, Integer cost) {
        if (size == data.length) {
            return false;
        }

        Entry entry = findEntry(item);
        if (entry == null) {
            data[hashFunc(item)].add(new Entry(item, cost));
            size++;
        } else {
            entry.value = cost;
        }
        return true;
    }

    private Entry findEntry(Item item) {
        int index = hashFunc(item);
        for (Entry entry:data[index]) {
            if (entry.key.equals(item)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public Integer get(Item item) {
        Entry entry = findEntry(item);
        return entry == null ? null : entry.value;
    }

    @Override
    public boolean remove(Item item) {
        Entry entry = findEntry(item);
        if (entry == null) {
            return false;
        }
        else {
            data[hashFunc(item)].remove(entry);
            size--;
        }
        return true;
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
    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("[%d]%n", i);
            for (Entry entry : data[i]) {
                System.out.printf("   %s%n", entry.toString());
            }
        }

    }
}
