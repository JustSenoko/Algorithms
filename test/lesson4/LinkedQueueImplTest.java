package lesson4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQueueImplTest {

    private LinkedQueueImpl<Integer> queue;
    private static final int SIZE = 5;

    @Before
    public void init() {
        queue = new LinkedQueueImpl<>();
    }

    @Test
    public void insert() {
        for (int i = 0; i < SIZE + 2; i++) {
            assertTrue(queue.insert(i));
        }
    }

    @Test
    public void remove() {
        assertNull(queue.remove());
        for (int i = 0; i < SIZE; i++) {
            queue.insert(i);
        }
        for (int i = 0; i < SIZE; i++) {
            assertEquals((Integer) i, queue.remove());
        }
    }

    @Test
    public void peek() {
        assertNull(queue.peek());
        for (int i = 0; i < SIZE + 2; i++) {
            queue.insert(i);
            assertEquals((Integer) 0, queue.peek());
        }
    }

    @Test
    public void size() {
        for (int i = 0; i < SIZE + 2; i++) {
            queue.insert(i);
            assertEquals(i + 1, queue.size());
        }
    }

    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty());
        for (int i = 0; i < SIZE + 2; i++) {
            queue.insert(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 0; i < SIZE + 2; i++) {
            queue.remove();
            assertEquals(i >= SIZE + 1, queue.isEmpty());
        }

    }

    @Test
    public void isFull() {
        assertFalse(queue.isFull());
        for (int i = 0; i < SIZE + 2; i++) {
            queue.insert(i);
            assertFalse(queue.isFull());
        }
    }
}