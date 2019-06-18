package lesson3.deque;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DequeImplTest {

    private DequeImpl<Integer> deque;
    private static final int MAX_SIZE = 5;

    @Before
    public void init() {
        deque = new DequeImpl<>(MAX_SIZE);
    }

    @Test
    public void insertRight() {
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            assertEquals(i < MAX_SIZE, deque.insertRight(i));
        }
    }

    @Test
    public void insertLeft() {
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            assertEquals(i < MAX_SIZE, deque.insertLeft(i));
        }
    }

    @Test
    public void removeRight() {
        assertNull(deque.removeRight());
        for (int i = 0; i < MAX_SIZE; i++) {
           deque.insertRight(i);
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            assertEquals((Integer) (MAX_SIZE - i - 1), deque.removeRight());
        }
    }

    @Test
    public void removeLeft() {
        assertNull(deque.removeLeft());
        for (int i = 0; i < MAX_SIZE; i++) {
            deque.insertLeft(i);
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            assertEquals((Integer) (MAX_SIZE - i - 1), deque.removeLeft());
        }
    }

    @Test
    public void peekRight() {
        assertNull(deque.peekRight());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            deque.insertRight(i);
            assertEquals((Integer) (i < MAX_SIZE ? i : MAX_SIZE - 1), deque.peekRight());
        }
    }

    @Test
    public void peekLeft() {
        assertNull(deque.peekLeft());
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            deque.insertLeft(i);
            assertEquals((Integer) (i < MAX_SIZE ? i : MAX_SIZE - 1), deque.peekLeft());
        }
    }

    @Test
    public void size() {
        for (int i = 0; i < MAX_SIZE + 2; i++) {
            deque.insertRight(i);
            assertEquals(i < MAX_SIZE ? i + 1 : MAX_SIZE, deque.size());
        }
    }

    @Test
    public void insertAndRemoveBothSides() {
        for (int i = 0; i < MAX_SIZE; i++) {
            deque.insertLeft(i);
        }
        assertArrayEquals(new Integer[]{4,3,2,1,0}, deque.getDataInOrder());
        //deque.print();
        for (int i = 0; i < MAX_SIZE/2; i++) {
            deque.removeLeft();
        }
        assertArrayEquals(new Integer[]{2,1,0}, deque.getDataInOrder());
        //deque.print();
        for (int i = 0; i < MAX_SIZE/2; i++) {
            deque.insertRight(i);
        }
        assertArrayEquals(new Integer[]{2,1,0,0,1}, deque.getDataInOrder());
        //deque.print();
        for (int i = 0; i < MAX_SIZE/2; i++) {
            deque.removeRight();
        }
        assertArrayEquals(new Integer[]{2,1,0}, deque.getDataInOrder());
        //deque.print();
    }
}