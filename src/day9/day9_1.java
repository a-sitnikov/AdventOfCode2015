package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;

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

        String inputFile = day9_1.class.getClassLoader().getResource("input9.txt").getFile();

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        String s;

        HashMap<String, Integer> cityIndexes = new HashMap<>();
        Integer cityIndex = 0;

        int[][] distanceMap = new int[10][10];

        int sum = 0;
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

        int min = 99999999;
        for (int i = 0; i < cityIndex; i++) {

            int totalDist = getShortestWay(distanceMap, i, cityIndex);
            if (totalDist < min) {
                min = totalDist;
            }

        }

        System.out.println(min);

    }

    public static int getShortestWay(int[][] distanceMap, int firstPoint, int citiesCount) {

        return 0;
    }

    public static int processString(String str, String[] cities) {

        String[] arr = str.split(" = ");

        String[] arr1 = arr[0].split(" to ");

        for (int i = 0; i < cities.length; i++) {
            cities[i] = arr1[i];
        }

        return Integer.valueOf(arr[1]);
    }
}