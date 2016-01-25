package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 --- Part Two ---

 The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents with him.

 Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.

 This year, how many houses receive at least one present?

 For example:

 ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
 ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
 ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.

 */
public class day3_2 {

    public static void main(String[] args) throws Exception {

        String inputFile = day3_2.class.getClassLoader().getResource("input3.txt").getFile();

        BufferedReader in = new BufferedReader(new FileReader(inputFile));

        HashMap<List<Integer>, Integer> map = new HashMap<>();

        Integer x1 = 0;
        Integer y1 = 0;

        Integer x2 = 0;
        Integer y2 = 0;

        map.put(Arrays.asList(x1, y1), 1);

        String s;
        while ((s = in.readLine()) != null) {

            char[] array = s.toCharArray();
            for (int i = 1; i < array.length; i += 2) {

                char c1 = array[i-1];
                char c2 = array[i];

                if (c1 == '<') {
                    x1--;
                } else if (c1 == '>') {
                    x1++;
                } else if (c1 == '^') {
                    y1++;
                } else if (c1 == 'v') {
                    y1--;
                }

                map.put(Arrays.asList(x1, y1), 1);

                if (c2 == '<') {
                    x2--;
                } else if (c2 == '>') {
                    x2++;
                } else if (c2 == '^') {
                    y2++;
                } else if (c2 == 'v') {
                    y2--;
                }

                map.put(Arrays.asList(x2, y2), 1);
            }

        }

        System.out.println(map.entrySet().size());
    }

}
