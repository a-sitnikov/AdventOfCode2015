package testDay10;

import org.junit.Test;

import static org.junit.Assert.*;

public class day10_1Test {

    @Test
    public void testGetNextString() throws Exception {

        String value;
        value = day10.day10_1.getNextString("1");
        assertEquals("11", value);

        value = day10.day10_1.getNextString("11");
        assertEquals("21", value);

        value = day10.day10_1.getNextString("21");
        assertEquals("1211", value);

        value = day10.day10_1.getNextString("1211");
        assertEquals("111221", value);

        value = day10.day10_1.getNextString("111221");
        assertEquals("312211", value);
    }
}