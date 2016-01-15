package task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;

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
public class task6_2 {

    public static void main(String[] args) throws Exception {

        String inputFile = task6_1.class.getClassLoader().getResource("input6.txt").getFile();

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
                    array[i][j] += 2;
                } else if (action.action.equals("turn off")) {
                    array[i][j] -= 1;
                    if (array[i][j] < 0) {
                        array[i][j] = 0;
                    }
                }  else if (action.action.equals("turn on")) {
                    array[i][j] += 1;
                }

            }

        }

    }

}