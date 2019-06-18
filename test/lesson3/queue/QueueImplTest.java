package lesson3.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueImplTest {
    private Queue<Integer> queue;
    private static final int MAX_SIZE = 5;

    @Before
    public void init() {
        queue = new QueueImpl<>(MAX_SIZE);
    }

    @Test
    public void insert() {
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            assertEquals(i < MAX_SIZE, queue.insert(i));
        }
    }

    @Test
    public void remove() {
        assertNull(queue.remove());
        for (int i = 0; i < MAX_SIZE; i++) {
            queue.insert(i);
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            assertEquals((Integer) i, queue.remove());
        }
    }

    @Test
    public void peek() {
        assertNull(queue.peek());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            queue.insert(i);
            assertEquals((Integer) 0, queue.peek());
        }
    }

    @Test
    public void size() {
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            queue.insert(i);
            assertEquals(i < MAX_SIZE ? i + 1 : MAX_SIZE, queue.size());
        }
    }

    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            queue.insert(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            queue.remove();
            assertEquals(i >= MAX_SIZE - 1, queue.isEmpty());
        }

    }

    @Test
    public void isFull() {
        assertFalse(queue.isFull());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            queue.insert(i);
            assertEquals(i >= MAX_SIZE - 1, queue.isFull());
        }
    }
}