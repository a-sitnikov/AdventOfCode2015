package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

/**
 --- Day 6: Probably a Fire Hazard ---

 Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to deploy one million lights in a 1000x1000 grid.

 Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the ideal lighting configuration.

 Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.

 To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.

 For example:

 turn on 0,0 through 999,999 would turn on (or leave on) every light.
 toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on, and turning on the ones that were off.
 turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.

 After following the instructions, how many lights are lit?

 */
public class Day6_1 {

    public static void main(String[] args) throws Exception {

        URL resource = Day6_1.class.getClassLoader().getResource("input6.txt");
        if (resource == null) {
            return;
        }

        int[][] grid = new int[1000][1000];

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            String s;
            while ((s = in.readLine()) != null) {

                Operation op = new Operation(s);//processString(s);

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
                    array[i][j] = 1 - array[i][j];
                } else if (op.operation.equals("turn off")) {
                    array[i][j] = 0;
                }  else if (op.operation.equals("turn on")) {
                    array[i][j] = 1;
                }

            }

        }

    }

}
