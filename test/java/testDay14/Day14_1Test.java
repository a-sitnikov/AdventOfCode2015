package testDay14;

import day14.Reindeer;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day14_1Test {

    @Test
    public void testParseString() throws Exception {

        Reindeer reindeer;
        reindeer = new Reindeer("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.");
        assertEquals("Comet", reindeer.name);
        assertEquals(14, reindeer.speed);
        assertEquals(10, reindeer.movingTime);
        assertEquals(127, reindeer.restTime);
        assertEquals(1120, reindeer.getDistanceAfter(1000));

        reindeer = new Reindeer("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.");
        assertEquals("Dancer", reindeer.name);
        assertEquals(16, reindeer.speed);
        assertEquals(11, reindeer.movingTime);
        assertEquals(162, reindeer.restTime);
        assertEquals(1056, reindeer.getDistanceAfter(1000));

    }

}