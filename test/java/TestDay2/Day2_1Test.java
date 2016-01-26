package testDay2;

import day2.Day2_1;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day2_1Test {

    @Test
    public void testProcessString() throws Exception {

        int value = Day2_1.processString("2x3x4");
        assertEquals(58, value);

        value = Day2_1.processString("1x1x10");
        assertEquals(43, value);

    }
}