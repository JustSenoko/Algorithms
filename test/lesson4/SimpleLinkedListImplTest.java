package lesson4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleLinkedListImplTest {

    private LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new SimpleLinkedListImpl<>();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
    }

    @Test
    public void removeFirst() {
        list.display(); //54321
        assertEquals((Integer) 5, list.removeFirst());
        list.display(); //4321
        assertEquals((Integer) 4, list.removeFirst());
        list.display(); //321
        assertEquals((Integer) 3, list.removeFirst());
        list.display(); //21
        assertEquals((Integer) 2, list.removeFirst());
        list.display(); //1
        assertEquals((Integer) 1, list.removeFirst());
        list.display(); //
        assertNull(list.removeFirst());
    }

    @Test
    public void removeFirstValue() {
        list.display(); //54321
        assertTrue(list.remove(5));
        list.display(); //4321
        assertTrue(list.remove(4));
        list.display(); //321
        assertTrue(list.remove(3));
        list.display(); //21
        assertTrue(list.remove(2));
        list.display(); //1
        assertTrue(list.remove(1));
        list.display(); //
    }

    @Test
    public void removeLastValue() {
        list.display(); //54321
        assertTrue(list.remove(1));
        list.display(); //5432
        assertTrue(list.remove(2));
        list.display(); //543
        assertTrue(list.remove(3));
        list.display(); //54
        assertTrue(list.remove(4));
        list.display(); //5
        assertTrue(list.remove(5));
        list.display(); //
    }

    @Test
    public void removeMiddleFirst() {
        list.display(); //54321
        assertTrue(list.remove(2));
        list.display(); //5431
        assertTrue(list.remove(3));
        list.display(); //541
        assertTrue(list.remove(4));
        list.display(); //51
    }

    @Test
    public void removeNotFoundValue() {
        assertFalse(list.remove(7));
        assertFalse(list.remove(8));
        assertFalse(list.remove(9));
    }

    @Test
    public void contains() {
        assertTrue(list.contains(1));
        assertTrue(list.contains(3));
        assertTrue(list.contains(5));
        assertFalse(list.contains(7));
        assertFalse(list.contains(8));
        assertFalse(list.contains(9));
    }

    @Test
    public void isEmpty() {
        assertFalse(list.isEmpty());
        for (int i = 0; i < list.size(); i++) {
            list.removeFirst();
            assertEquals(i == 4, list.isEmpty());
        }
    }

    @Test
    public void size() {
        assertEquals(5, list.size());
    }

    @Test
    public void getFirstValue() {
        assertEquals((Integer) 5, list.getFirstValue());
    }
}