package task1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 --- Part Two ---

 Now, given the same instructions, find the position of the first character that causes him to enter the basement (floor -1). The first character in the instructions has position 1, the second character has position 2, and so on.

 For example:

 ) causes him to enter the basement at character position 1.
 ()()) causes him to enter the basement at character position 5.

 What is the position of the character that causes Santa to first enter the basement?

 */
public class task1_2 {

    public static void main(String[] args) throws Exception {

        String inputFile = task1_2.class.getClassLoader().getResource("input1.txt").getFile();

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        int sum = 0;

        String s;
        while ((s = in.readLine()) != null) {

            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {

                if (array[i] == '(') {
                    sum++;
                } else if (array[i] == ')') {
                    sum--;
                }

                if (sum == -1) {
                    System.out.println((i+1));
                    break;
                }

            }

        }

        System.out.println(sum);
    }

}