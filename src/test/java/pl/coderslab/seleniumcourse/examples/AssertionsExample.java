package pl.coderslab.seleniumcourse.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.coderslab.seleniumcourse.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsExample {
    @Test
    public void shouldReturnValidAddResult() {
        // given
        int a = 2;
        int b = 40;
        // when
        int actual = Calculator.add(a, b);
        // then
        Assertions.assertEquals(42, actual);
    }

    @Test
    public void assertionsExample() {
        assertTrue(3>2);
        assertFalse(4<3);
        assertNotNull(new Object());
        assertNull(null);
        assertEquals(42, 42);
        assertEquals(3.14, 3.14);
        assertEquals(true, true);
        assertEquals("napis", "napis");
        int[] arr1 = {1,2,42};
        int[] arr2 = {1,2,42};
        assertArrayEquals(arr1, arr2);
    }
}
