package testDay5;


import day5.Day5_1;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day5_1Test {

    @Test
    public void testIsNiceString() throws Exception {

        boolean value = Day5_1.isNiceString("ugknbfddgicrmopn");
        assertEquals(true, value);

        value = Day5_1.isNiceString("jchzalrnumimnmhp");
        assertEquals(false, value);

        value = Day5_1.isNiceString("haegwjzuvuyypxyu");
        assertEquals(false, value);

        value = Day5_1.isNiceString("dvszwmarrgswjxmb");
        assertEquals(false, value);
    }
}