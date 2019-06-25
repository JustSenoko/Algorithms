package lesson4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSideLinkedListImplTest {

    private TwoSideLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new TwoSideLinkedListImpl<>();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
    }

    @Test
    public void insertLast() {
        list.insertLast(4);
        list.display(); //1234
        list.insertLast(5);
        list.display(); //12345
    }

    @Test
    public void removeLast() {
        assertEquals((Integer) 3, list.removeLast());
        assertEquals((Integer) 2, list.removeLast());
        assertEquals((Integer) 1, list.removeLast());
        assertNull(list.removeLast());
    }

    @Test
    public void getLastValue() {
        assertEquals((Integer) 3, list.getLastValue());
    }

    @Test
    public void insertFirst() {
        list.insertFirst(0);
        list.display(); //0123
        list.insertFirst(-1);
        list.display(); //-10123
    }

    @Test
    public void removeFirst() {
        assertEquals((Integer) 1, list.removeFirst());
        assertEquals((Integer) 2, list.removeFirst());
        assertEquals((Integer) 3, list.removeFirst());
        assertNull(list.removeFirst());
    }

    @Test
    public void removeFirstValue() {
        assertTrue(list.remove(1));
        list.display(); //23
        assertTrue(list.remove(2));
        list.display(); //3
        assertTrue(list.remove(3));
        list.display(); //
    }

    @Test
    public void removeMediumValue() {
        assertTrue(list.remove(2));
        list.display(); //13
    }

    @Test
    public void removeLastValue() {
        assertTrue(list.remove(3));
        list.display(); //12
        assertTrue(list.remove(2));
        list.display(); //1
        assertTrue(list.remove(1));
        list.display(); //
    }

    @Test
    public void removeNotFoundValue() {
        assertFalse(list.remove(7));
        assertFalse(list.remove(8));
        assertFalse(list.remove(9));
    }
}