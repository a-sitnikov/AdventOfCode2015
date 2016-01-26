package testDay4;

import day4.Day4_1;
import org.junit.Test;

import static org.junit.Assert.*;

public class day4_1Test {

    @Test
    public void testMD5() throws Exception {

        String value = Day4_1.MD5("abcdef609043");
        assertEquals("000001dbbfa", value.substring(0, "000001dbbfa".length()));
    }
}