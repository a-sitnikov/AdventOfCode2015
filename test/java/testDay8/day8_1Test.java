package testDay8;

import day8.day8_1;
import org.junit.Test;

import static org.junit.Assert.*;

public class day8_1Test {

    @Test
    public void testProcessString() throws Exception {

        int value;
        value = day8_1.processString("\"\"");
        assertEquals(2-0, value);

        value = day8_1.processString("\"abc\"");
        assertEquals(5-3, value);

        value = day8_1.processString("\"aaa\\\"aaa\"");
        assertEquals(10-7, value);

        value = day8_1.processString("\"\\x27\"");
        assertEquals(6-1, value);
    }
}