package testDay9;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by acsen on 26.01.2016.
 */
public class day9_2Test {

    @Test
    public void testGetNextRoute() throws Exception {

        int[] array = new int[]{1, 2, 3, 4};

        day9.day9_2.getNextRoute(array);
        assertArrayEquals(new int[]{1, 2, 4, 3}, array);

        day9.day9_2.getNextRoute(array);
        assertArrayEquals(new int[]{1, 3, 2, 4}, array);

    }

    @Test
    public void testGetLongestRoute() throws Exception {

        int[][] distanceMap = new int[3][3];

        distanceMap[0] = new int[]{0,   464, 518};
        distanceMap[1] = new int[]{464,   0, 141};
        distanceMap[2] = new int[]{518, 141,   0};

        int cityIndex = 3;
        int value = day9.day9_2.getLongestRoute(distanceMap, cityIndex);
        assertEquals(982, value);

    }
}