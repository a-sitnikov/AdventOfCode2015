package testDay3;

import day3.Day3_1;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day3_1Test {

    @Test
    public void testProcessString() throws Exception {

        int value = Day3_1.processString(">");
        assertEquals(2, value);

        value = Day3_1.processString("^>v<");
        assertEquals(4, value);

        value = Day3_1.processString("^v^v^v^v^v");
        assertEquals(2, value);

    }
}