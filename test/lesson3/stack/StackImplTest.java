package lesson3.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackImplTest {
    private Stack<Integer> stack;
    private static final int MAX_SIZE = 5;

    @Before
    public void init() {
        stack = new StackImpl<>(MAX_SIZE);
    }

    @Test
    public void push() {
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            assertEquals(i < MAX_SIZE, stack.push(i));
        }
    }

    @Test
    public void pop() {
        assertNull(stack.pop());
        for (int i = 0; i < MAX_SIZE; i++) {
            stack.push(i);
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            assertEquals((Integer) (MAX_SIZE - i - 1), stack.pop());
        }
    }

    @Test
    public void size() {
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            stack.push(i);
            assertEquals(i < MAX_SIZE ? i + 1 : MAX_SIZE, stack.size());
        }
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());
        for (int i = 0; i < MAX_SIZE; i++) {
            stack.push(i);
            assertFalse(stack.isEmpty());
        }

        for (int i = 0; i < MAX_SIZE; i++) {
            stack.pop();
            assertEquals(i == MAX_SIZE - 1, stack.isEmpty());
        }

    }

    @Test
    public void isFull() {
        assertFalse(stack.isFull());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            stack.push(i);
            assertEquals(i >= MAX_SIZE - 1, stack.isFull());
        }
    }

    @Test
    public void peek() {
        assertNull(stack.peek());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            stack.push(i);
            assertEquals((Integer) (i < MAX_SIZE ? i : MAX_SIZE - 1), stack.peek());
        }
    }
}