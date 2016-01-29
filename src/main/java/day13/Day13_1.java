package day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;

/**
 --- Day 13: Knights of the Dinner Table ---

 In years past, the holiday feast with your family hasn't gone so well. Not everyone gets along! This year, you resolve, will be different. You're going to find the optimal seating arrangement and avoid all those awkward conversations.

 You start by writing up a list of everyone invited and the amount their happiness would increase or decrease if they were to find themselves sitting next to each other person. You have a circular table that will be just big enough to fit everyone comfortably, and so each person will have exactly two neighbors.

 For example, suppose you have only four attendees planned, and you calculate their potential happiness as follows:

 Alice would gain 54 happiness units by sitting next to Bob.
 Alice would lose 79 happiness units by sitting next to Carol.
 Alice would lose 2 happiness units by sitting next to David.
 Bob would gain 83 happiness units by sitting next to Alice.
 Bob would lose 7 happiness units by sitting next to Carol.
 Bob would lose 63 happiness units by sitting next to David.
 Carol would lose 62 happiness units by sitting next to Alice.
 Carol would gain 60 happiness units by sitting next to Bob.
 Carol would gain 55 happiness units by sitting next to David.
 David would gain 46 happiness units by sitting next to Alice.
 David would lose 7 happiness units by sitting next to Bob.
 David would gain 41 happiness units by sitting next to Carol.

 Then, if you seat Alice next to David, Alice would lose 2 happiness units (because David talks so much), but David would gain 46 happiness units (because Alice is such a good listener), for a total change of 44.

 If you continue around the table, you could then seat Bob next to Alice (Bob gains 83, Alice gains 54). Finally, seat Carol, who sits next to Bob (Carol gains 60, Bob loses 7) and David (Carol gains 55, David gains 41). The arrangement looks like this:

 +41 +46
 +55   David    -2
 Carol       Alice
 +60    Bob    +54
 -7  +83

 After trying every other seating arrangement in this hypothetical scenario, you find that this one is the most optimal, with a total change in happiness of 330.

 What is the total change in happiness for the optimal seating arrangement of the actual guest list?

 */

public class Day13_1 {

    public static int peopleCount;

    public static void main(String[] args) throws Exception {

        URL resource = Day13_1.class.getClassLoader().getResource("input13.txt");
        if (resource == null) {
            return;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            int[][] happinessMap = getHappinessMap(in);
            int maxHappiness = getMaxHappiness(happinessMap);

            System.out.println(maxHappiness);

        }

    }

    public static int[][] getHappinessMap(BufferedReader in) throws Exception{

        String s;
        HashMap<String, Integer> names = new HashMap<>();
        int[][] tempArray = new int[20][20];
        int nameIndex = 0;

        while ((s = in.readLine()) != null) {

            Struct struct = new Struct(s);

            Integer index1 = names.get(struct.name1);
            if (index1 == null) {
                names.put(struct.name1, nameIndex);
                index1 = nameIndex;
                nameIndex++;
            }

            Integer index2 = names.get(struct.name2);
            if (index2 == null) {
                names.put(struct.name2, nameIndex);
                index2 = nameIndex;
                nameIndex++;
            }

            tempArray[index1][index2] += struct.happiness;
            tempArray[index2][index1] += struct.happiness;

        }

        peopleCount = nameIndex;
        int[][] happinessMap = new int[peopleCount][peopleCount];

        for (int i = 0; i < nameIndex; i++) {
            System.arraycopy(tempArray[i], 0, happinessMap[i], 0, peopleCount);
        }

        return happinessMap;

    }

    public static int getMaxHappiness(int[][] happinessMap) {

        int [] cycle = new int[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            cycle[i] = i;
        }

        int max = 0;
        while (true) {

            int totalDist = getTotalHappiness(happinessMap, cycle);
            if (totalDist > max) {
                max = totalDist;
            }

            if (!getNext(cycle)) {
                break;
            }
        }

        return max;

    }

    public static int getTotalHappiness(int[][] happinessMap, int[] cycle) {

        int sum = 0;
        for (int i = 1; i < cycle.length; i++) {
            sum += happinessMap[cycle[i-1]][cycle[i]];
        }

        sum += happinessMap[cycle[0]][cycle[cycle.length-1]];

        return sum;
    }

    public static boolean getNext(int[] array) {

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

}