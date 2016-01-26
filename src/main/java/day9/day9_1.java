package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;

/**
 --- Day 9: All in a Single Night ---

 Every year, Santa manages to deliver all of his presents in a single night.

 This year, however, he has some new locations to visit; his elves have provided him the distances between every pair of locations. He can start and end at any two (different) locations he wants, but he must visit each location exactly once. What is the shortest distance he can travel to achieve this?

 For example, given the following distances:

 London to Dublin = 464
 London to Belfast = 518
 Dublin to Belfast = 141

 The possible routes are therefore:

 Dublin -> London -> Belfast = 982
 London -> Dublin -> Belfast = 605
 London -> Belfast -> Dublin = 659
 Dublin -> Belfast -> London = 659
 Belfast -> Dublin -> London = 605
 Belfast -> London -> Dublin = 982

 The shortest of these is London -> Dublin -> Belfast = 605, and so the answer is 605 in this example.

 What is the distance of the shortest route?

 */
public class day9_1 {

    public static void main(String[] args) throws Exception {

        URL resource = day9_1.class.getClassLoader().getResource("input9.txt");
        if (resource == null) {
            return;
        }

        HashMap<String, Integer> cityIndexes = new HashMap<>();
        Integer cityIndex = 0;

        int[][] distanceMap = new int[10][10];

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            String s;

            while ((s = in.readLine()) != null) {

                String[] cities = new String[2];
                int dist = processString(s, cities);

                for (String city : cities) {
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
        }

        int min = 99999999;
        for (int i = 0; i < cityIndex; i++) {

            int totalDist = getShortestRoute(distanceMap, i, cityIndex);
            if (totalDist < min) {
                min = totalDist;
            }

        }

        System.out.println(min);

    }

    public static int getShortestRoute(int[][] distanceMap, int firstCity, int citiesCount) {

        // Dijkstra algorithm
        HashSet<Integer> set = new HashSet<>();

        int currentCity = firstCity;
        int nextCity = 0;
        int totalDist = 0;

        int[] route = new int[citiesCount];
        route[0] = currentCity;

        set.add(currentCity);

        for (int i = 0; i < citiesCount-1; i++) {

            int min = 99999999;

            for (int j = 0; j < citiesCount; j++) {

                if (currentCity == j) continue;
                if (set.contains(j)) continue;

                if (distanceMap[currentCity][j] < min) {

                    min = distanceMap[currentCity][j];
                    nextCity = j;
                }

            }

            set.add(nextCity);
            route[i+1] = nextCity;
            totalDist += min;

            currentCity = nextCity;

        }

        return totalDist;
    }

    public static int processString(String str, String[] cities) {

        String[] arr = str.split(" = ");

        String[] arr1 = arr[0].split(" to ");

        System.arraycopy(arr1, 0, cities, 0, cities.length);

        return Integer.valueOf(arr[1]);
    }
}