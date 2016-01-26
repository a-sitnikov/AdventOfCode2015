package testDay2;

import day2.Day2_2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day2_2Test {

    @Test
    public void testProcessString() throws Exception {

        int value = Day2_2.processString("2x3x4");
        assertEquals(34, value);

        value = Day2_2.processString("1x1x10");
        assertEquals(14, value);

    }
}