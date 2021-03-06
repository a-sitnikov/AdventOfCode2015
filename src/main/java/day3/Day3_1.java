package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 --- Day 3: Perfectly Spherical Houses in a Vacuum ---

 Santa is delivering presents to an infinite two-dimensional grid of houses.

 He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), or west (<). After each move, he delivers another present to the house at his new location.

 However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off, and Santa ends up visiting some houses more than once. How many houses receive at least one present?

 For example:

 > delivers presents to 2 houses: one at the starting location, and one to the east.
 ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
 ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.

 */
public class Day3_1 {

    public static void main(String[] args) throws Exception {

        URL resource = Day3_1.class.getClassLoader().getResource("input3.txt");
        if (resource == null) {
            return;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            String s;
            while ((s = in.readLine()) != null) {

                int value = processString(s);
                System.out.println(value);

            }

        }

    }

    public static int processString(String str) {

        Integer x = 0;
        Integer y = 0;

        HashMap<List<Integer>, Integer> map = new HashMap<>();
        map.put(Arrays.asList(x, y), 1);

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            switch (c) {
                case '<':
                    x--;
                    break;
                case '>':
                    x++;
                    break;
                case '^':
                    y++;
                    break;
                case 'v':
                    y--;
                    break;
            }

            map.put(Arrays.asList(x, y), 1);

        }

        return map.entrySet().size();
    }
}
