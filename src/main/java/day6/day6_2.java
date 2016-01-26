package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

/**
 -- Part Two ---

 You just finish implementing your winning light pattern when you realize you mistranslated Santa's message from Ancient Nordic Elvish.

 The light grid you bought actually has individual brightness controls; each light can have a brightness of zero or more. The lights all start at zero.

 The phrase turn on actually means that you should increase the brightness of those lights by 1.

 The phrase turn off actually means that you should decrease the brightness of those lights by 1, to a minimum of zero.

 The phrase toggle actually means that you should increase the brightness of those lights by 2.

 What is the total brightness of all lights combined after following Santa's instructions?

 For example:

 turn on 0,0 through 0,0 would increase the total brightness by 1.
 toggle 0,0 through 999,999 would increase the total brightness by 2000000.

 */
public class Day6_2 {

    public static void main(String[] args) throws Exception {

        URL resource = Day6_1.class.getClassLoader().getResource("input6.txt");
        if (resource == null) {
            return;
        }

        int[][] grid = new int[1000][1000];

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            String s;
            while ((s = in.readLine()) != null) {

                Operation op = new Operation(s);

                perfomOperation(grid, op);

            }

            int sum = getSum(grid);
            System.out.println(sum);

        }

    }

    public static int getSum(int[][] array) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }

        }

        return sum;

    }

    public static void perfomOperation(int[][] array, Operation op) {

        for (int i = op.x1; i <= op.x2; i++) {

            for (int j = op.y1; j <= op.y2 ; j++) {

                if (op.operation.equals("toggle")) {
                    array[i][j] += 2;
                } else if (op.operation.equals("turn off")) {
                    array[i][j] -= 1;
                    if (array[i][j] < 0) {
                        array[i][j] = 0;
                    }
                }  else if (op.operation.equals("turn on")) {
                    array[i][j] += 1;
                }

            }

        }

    }

}