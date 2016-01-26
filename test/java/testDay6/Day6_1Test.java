package testDay6;

import day6.Day6_1;
import day6.Operation;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day6_1Test {

    @Test
    public void testProcessString() throws Exception {

        Operation op;

        op = new Operation("turn on 0,0 through 999,999");
        assertEquals("turn on", op.operation);
        assertEquals(0, op.x1);
        assertEquals(0, op.y1);

        assertEquals(999, op.x2);
        assertEquals(999, op.y2);

        op = new Operation("toggle 0,0 through 999,0");
        assertEquals("toggle", op.operation);
        assertEquals(0, op.x1);
        assertEquals(0, op.y1);

        assertEquals(999, op.x2);
        assertEquals(0,   op.y2);

        op = new Operation("turn off 499,499 through 500,500");
        assertEquals("turn off", op.operation);
        assertEquals(499, op.x1);
        assertEquals(499, op.y1);

        assertEquals(500, op.x2);
        assertEquals(500, op.y2);

    }
}