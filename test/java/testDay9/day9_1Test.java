package testDay9;

import org.junit.Test;

import static org.junit.Assert.*;

public class day9_1Test {

    @Test
    public void testGetShortestRoute() throws Exception {

        int[][] distanceMap = new int[3][3];

        distanceMap[0] = new int[]{0,   464, 518};
        distanceMap[1] = new int[]{464,   0, 141};
        distanceMap[2] = new int[]{518, 141,   0};

        int cityIndex = 3;
        int min = 99999999;
        for (int i = 0; i < cityIndex; i++) {

            int totalDist = day9.day9_1.getShortestRoute(distanceMap, i, cityIndex);
            if (totalDist < min) {
                min = totalDist;
            }

        }

        assertEquals(605, min);

    }

    @Test
    public void testProcessString() throws Exception {

        String[] cities = new String[2];
        int value;

        value = day9.day9_1.processString("London to Dublin = 464", cities);
        assertEquals(464, value);
        assertArrayEquals(new String[]{"London", "Dublin"}, cities);

        value = day9.day9_1.processString("London to Belfast = 518", cities);
        assertEquals(518, value);
        assertArrayEquals(new String[]{"London", "Belfast"}, cities);

        value = day9.day9_1.processString("Dublin to Belfast = 141", cities);
        assertEquals(141, value);
        assertArrayEquals(new String[]{"Dublin", "Belfast"}, cities);

    }
}