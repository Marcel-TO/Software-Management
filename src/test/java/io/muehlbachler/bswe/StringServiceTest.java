package io.muehlbachler.bswe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringServiceTest {
    private StringService stringService = new StringService();

    @Test
    public void testToUpperCase() {
        assertEquals("ABC", stringService.toUpperCase("abc"), "abc toUpperCase should be ABC");
    }

    @Test
    public void testToUpperCaseNull() {
        assertThrows(IllegalArgumentException.class, () -> stringService.toUpperCase(null));
    }
    @Test
    public void testToUpperCaseEmpty() {
        assertEquals("", stringService.toUpperCase(""));
    }
}
