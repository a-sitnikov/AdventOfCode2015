package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

/**
 --- Part Two ---

 Now, given the same instructions, find the position of the first character that causes him to enter the basement (floor -1). The first character in the instructions has position 1, the second character has position 2, and so on.

 For example:

 ) causes him to enter the basement at character position 1.
 ()()) causes him to enter the basement at character position 5.

 What is the position of the character that causes Santa to first enter the basement?

 */
public class Day1_2 {

    public static void main(String[] args) throws Exception {

        URL resource = Day1_1.class.getClassLoader().getResource("input1.txt");
        if (resource == null) {
            return;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            int sum;

            String s;
            while ((s = in.readLine()) != null) {

                sum = processString(s);
                System.out.println(sum);

            }
        }

    }

    public static int processString(String str) {

        char[] array = str.toCharArray();
        int sum = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == '(') {
                sum++;
            } else if (array[i] == ')') {
                sum--;
            }

            if (sum == -1) {
                return i + 1;
            }

        }

        return 0;

    }
}
