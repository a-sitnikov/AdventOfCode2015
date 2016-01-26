package testDay3;

import day3.Day3_2;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day3_2Test {

    @Test
    public void testProcessString() throws Exception {

        int value = Day3_2.processString("^v");
        assertEquals(3, value);

        value = Day3_2.processString("^>v<");
        assertEquals(3, value);

        value = Day3_2.processString("^v^v^v^v^v");
        assertEquals(11, value);

    }
}