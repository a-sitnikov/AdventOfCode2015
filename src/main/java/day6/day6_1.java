package day6;

import java.io.BufferedReader;
import java.io.FileReader;

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
public class day6_1 {

    public static void main(String[] args) throws Exception {

        String inputFile = day6_1.class.getClassLoader().getResource("input6.txt").getFile();

        int[][] array = new int[1000][1000];
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 0;
            }

        }

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        String s;
        while ((s = in.readLine()) != null) {

            Action action = processString(s);
            //System.out.println(s);
            //System.out.println(action.action + "-" + action.x1 + "," + action.y1 + ":" + action.x2 + "," + action.y2);

            makeAction(array, action);

        }

        int sum = getSum(array);
        System.out.println(sum);

    }

    public static Action processString(String str) {

        //turn off 660,55 through 986,197
        //toggle 322,558 through 977,958
        //turn on 226,196 through 599,390

        Action action = new Action();

        Integer ind = str.indexOf("through");
        String s2 = str.substring(ind + 7).trim();
        int[] arr = getCoords(s2);
        action.x2 = arr[0];
        action.y2 = arr[1];

        str = str.substring(0, ind).trim();
        ind = str.lastIndexOf(" ");

        action.action = str.substring(0, ind).trim();
        String s1 = str.substring(ind).trim();
        arr = getCoords(s1);
        action.x1 = arr[0];
        action.y1 = arr[1];

        return action;

    }

    public static int[] getCoords(String str) {

        //906,775
        int ind = str.indexOf(",");
        String s1 = str.substring(0, ind);
        String s2 = str.substring(ind+1);

        return new int[]{Integer.valueOf(s1), Integer.valueOf(s2)};
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

    public static void makeAction(int[][] array, Action action) {

        for (int i = action.x1; i <= action.x2; i++) {

            for (int j = action.y1; j <= action.y2 ; j++) {

                if (action.action.equals("toggle")) {
                    array[i][j] = 1 - array[i][j];
                } else if (action.action.equals("turn off")) {
                    array[i][j] = 0;
                }  else if (action.action.equals("turn on")) {
                    array[i][j] = 1;
                }

            }

        }

    }

}