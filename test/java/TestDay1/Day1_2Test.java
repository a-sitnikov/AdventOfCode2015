package TestDay1;

import Day1.Day1_2;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day1_2Test {

    @Test
    public void testProcessString() throws Exception {

        int value = Day1_2.processString(")");
        assertEquals(value, 1);

        value = Day1_2.processString("()())");
        assertEquals(value, 5);

    }
}