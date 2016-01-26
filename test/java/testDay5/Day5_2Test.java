package testDay5;

import day5.Day5_2;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msk5446 on 26.01.2016.
 */
public class Day5_2Test {

    @Test
    public void testIsNiceString() throws Exception {

        boolean value = Day5_2.isNiceString("qjhvhtzxzqqjkmpb");
        assertEquals(true, value);

        value = Day5_2.isNiceString("xxyxx");
        assertEquals(true, value);

        value = Day5_2.isNiceString("uurcxstgmygtbstg");
        assertEquals(false, value);

        value = Day5_2.isNiceString("ieodomkazucvgmuy");
        assertEquals(false, value);

    }
}