package testDay1;

import day1.Day1_1;
import org.junit.Test;


import static org.junit.Assert.*;

public class Day1_1Test {

    @Test
    public void testProcessString() throws Exception {

        int value = Day1_1.processString("(())");
        assertEquals(value, 0);

        value = Day1_1.processString("()()");
        assertEquals(value, 0);

        value = Day1_1.processString("(((");
        assertEquals(value, 3);

        value = Day1_1.processString("(()(()(");
        assertEquals(value, 3);

        value = Day1_1.processString("))(((((");
        assertEquals(value, 3);

        value = Day1_1.processString("())");
        assertEquals(value, -1);

        value = Day1_1.processString("))(");
        assertEquals(value, -1);

        value = Day1_1.processString(")))");
        assertEquals(value, -3);

        value = Day1_1.processString(")())())");
        assertEquals(value, -3);

    }
}