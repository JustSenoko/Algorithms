package lesson5;

import org.junit.Test;

import static lesson5.Degree.degree;
import static org.junit.Assert.*;

public class DegreeTest {

    @Test
    public void degreeTest() {
        double delta = 0.000001;
        assertEquals(Math.pow(2, 3), degree(2, 3), delta);
        assertEquals(Math.pow(3, 3), degree(3, 3), delta);
        assertEquals(Math.pow(1, 10), degree(1, 10), delta);
        assertEquals(Math.pow(1, -3), degree(1, -3), delta);
        assertEquals(Math.pow(0, 3), degree(0, 3), delta);
        assertEquals(Math.pow(-5, 3), degree(-5, 3), delta);
        assertEquals(Math.pow(0, -1), degree(0, -1), delta);
        assertEquals(Math.pow(0, 0), degree(0, 0), delta);
        assertEquals(Math.pow(1.5, 3), degree(1.5, 3), delta);
    }

}