package day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;

/**
 --- Part Two ---

 In all the commotion, you realize that you forgot to seat yourself. At this point, you're pretty apathetic toward the whole thing, and your happiness wouldn't really go up or down regardless of who you sit next to. You assume everyone else would be just as ambivalent about sitting next to you, too.

 So, add yourself to the list, and give all happiness relationships that involve you a score of 0.

 What is the total change in happiness for the optimal seating arrangement that actually includes yourself?

 */

public class Day13_2 {

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

        peopleCount = nameIndex+1;
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