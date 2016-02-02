package testDay14;

import day14.Reindeer;
import day14.ReindeerHashMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day14_2Test {

    @Test
    public void testGetWinnerScore() throws Exception {

        ReindeerHashMap reindeerHashMap = new ReindeerHashMap();

        Reindeer reindeer = new Reindeer("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.");
        reindeerHashMap.put(reindeer, 0);

        reindeer = new Reindeer("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.");
        reindeerHashMap.put(reindeer, 0);

        int score = reindeerHashMap.getWinnerScoreAfter(1000);
        assertEquals(689, score);
    }

}