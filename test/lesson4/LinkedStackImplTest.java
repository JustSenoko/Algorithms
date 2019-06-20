package lesson4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedStackImplTest {
    private LinkedStackImpl<Integer> stack;
    private static final int SIZE = 5;

    @Before
    public void init() {
        stack = new LinkedStackImpl<>();
    }

    @Test
    public void push() {
        for (int i = 0; i < SIZE; i++) {
            assertTrue(stack.push(i));
        }
    }

    @Test
    public void pop() {
        assertNull(stack.pop());
        for (int i = 0; i < SIZE; i++) {
            stack.push(i);
        }
        for (int i = 0; i < SIZE; i++) {
            assertEquals((Integer) (SIZE - i - 1), stack.pop());
        }
    }

    @Test
    public void size() {
        for (int i = 0; i < SIZE + 2; i++) {
            stack.push(i);
            assertEquals(i + 1, stack.size());
        }
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());
        for (int i = 0; i < SIZE; i++) {
            stack.push(i);
            assertFalse(stack.isEmpty());
        }

        for (int i = 0; i < SIZE; i++) {
            stack.pop();
            assertEquals(i == SIZE - 1, stack.isEmpty());
        }

    }

    @Test
    public void isFull() {
        assertFalse(stack.isFull());
        for (int i = 0; i < SIZE + 2; i++) {
            stack.push(i);
            assertFalse(stack.isFull());
        }
    }

    @Test
    public void peek() {
        assertNull(stack.peek());
        for (int i = 0; i < SIZE + 2; i++) {
            stack.push(i);
            assertEquals((Integer) i, stack.peek());
        }
    }
}