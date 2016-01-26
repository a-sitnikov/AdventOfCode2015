package testDay8;

import day8.day8_2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class day8_2Test {

    @Test
    public void testProcessString() throws Exception {

        int value;
        value = day8_2.processString("\"\"");
        assertEquals(6-2, value);

        value = day8_2.processString("\"abc\"");
        assertEquals(9-5, value);

        value = day8_2.processString("\"aaa\\\"aaa\"");
        assertEquals(16-10, value);

        value = day8_2.processString("\"\\x27\"");
        assertEquals(11-6, value);

    }
}