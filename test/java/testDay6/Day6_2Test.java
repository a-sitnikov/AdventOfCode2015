package testDay6;

import day6.Day6_2;
import day6.Operation;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day6_2Test {

    @Test
    public void testPerfomOperation() throws Exception {

        int[][] grid = new int[1000][1000];

        Operation op;
        op = new Operation("turn on 0,0 through 0,0");
        Day6_2.perfomOperation(grid, op);

        assertEquals(1, Day6_2.getSum(grid));

        grid = new int[1000][1000];

        op = new Operation("toggle 0,0 through 999,999");
        Day6_2.perfomOperation(grid, op);

        assertEquals(2000000, Day6_2.getSum(grid));
    }

}