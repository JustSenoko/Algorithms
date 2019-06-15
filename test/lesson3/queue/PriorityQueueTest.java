package lesson3.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    private PriorityQueue<Integer> pQueue;
    private static final int MAX_SIZE = 5;

    @Before
    public void init() {
        pQueue = new PriorityQueue<>(MAX_SIZE);
    }

    @Test
    public void insert() {
        Random rn = new Random();
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            int value = rn.nextInt(MAX_SIZE);
            assertEquals(i < MAX_SIZE, pQueue.insert(value));
            //pQueue.print();
        }
    }

    @Test
    public void remove() {
        assertNull(pQueue.remove());
        pQueue.insert(5);
        pQueue.insert(3);
        pQueue.insert(2);
        pQueue.insert(1);
        pQueue.insert(4);

        for (int i = 1; i <= 5; i++) {
            assertEquals((Integer) i, pQueue.remove());
        }
    }

    @Test
    public void peek() {
        assertNull(pQueue.peek());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            pQueue.insert(i);
            assertEquals((Integer) 0, pQueue.peek());
        }
    }

    @Test
    public void size() {
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            pQueue.insert(i);
            assertEquals(i < MAX_SIZE ? i + 1 : MAX_SIZE, pQueue.size());
        }
    }

    @Test
    public void isEmpty() {
        assertTrue(pQueue.isEmpty());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            pQueue.insert(i);
            assertFalse(pQueue.isEmpty());
        }
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            pQueue.remove();
            assertEquals(i >= MAX_SIZE - 1, pQueue.isEmpty());
        }

    }

    @Test
    public void isFull() {
        assertFalse(pQueue.isFull());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            pQueue.insert(i);
            assertEquals(i >= MAX_SIZE - 1, pQueue.isFull());
        }
    }
}