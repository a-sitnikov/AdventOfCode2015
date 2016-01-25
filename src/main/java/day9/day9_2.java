package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 --- Part Two ---

 The next year, just to show off, Santa decides to take the route with the longest distance instead.

 He can still start and end at any two (different) locations he wants, and he still must visit each location exactly once.

 For example, given the distances above, the longest route would be 982 via (for example) Dublin -> London -> Belfast.

 What is the distance of the longest route?

 */
public class day9_2 {

    public static void main(String[] args) throws Exception {

        String inputFile = day9_1.class.getClassLoader().getResource("input9.txt").getFile();

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        String s;

        HashMap<String, Integer> cityIndexes = new HashMap<>();
        Integer cityIndex = 0;

        int[][] distanceMap = new int[10][10];

        while ((s = in.readLine()) != null) {

            String[] cities = new String[2];
            int dist = processString(s, cities);

            for (String city: cities) {
                if (cityIndexes.get(city) == null) {
                    cityIndexes.put(city, cityIndex);
                    cityIndex++;
                }
            }

            int i = cityIndexes.get(cities[0]);
            int j = cityIndexes.get(cities[1]);

            distanceMap[i][j] = dist;
            distanceMap[j][i] = dist;

        }

        int[] route = new int[cityIndex];
        for (int i = 0; i < route.length; i++) {
            route[i] = i;
        }

        int max = 0;
        while (true) {

            int totalDist = getRouteDistance(distanceMap, route);
            if (totalDist > max) {
                max = totalDist;
            }

            if (!getNextRoute(route)) {
                break;
            }
        }

        System.out.println(max);

    }

    public static boolean getNextRoute(int[] array) {

        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return true;
    }

    public static int getRouteDistance(int[][] distanceMap, int[] route) {

        int dist = 0;
        for (int i = 1; i < route.length; i++) {
            dist += distanceMap[route[i-1]][route[i]];
        }

        return dist;
    }

    public static int processString(String str, String[] cities) {

        String[] arr = str.split(" = ");

        String[] arr1 = arr[0].split(" to ");

        System.arraycopy(arr1, 0, cities, 0, cities.length);

        return Integer.valueOf(arr[1]);
    }
}
