package day8;

import day6.Action;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 --- Part Two ---

 Now, let's go the other way. In addition to finding the number of characters of code, you should now encode each code representation as a new string and find the number of characters of the new encoded representation, including the surrounding double quotes.

 For example:

 "" encodes to "\"\"", an increase from 2 characters to 6.
 "abc" encodes to "\"abc\"", an increase from 5 characters to 9.
 "aaa\"aaa" encodes to "\"aaa\\\"aaa\"", an increase from 10 characters to 16.
 "\x27" encodes to "\"\\x27\"", an increase from 6 characters to 11.

 Your task is to find the total number of characters to represent the newly encoded strings minus the number of characters of code in each original string literal. For example, for the strings above, the total encoded length (6 + 9 + 16 + 11 = 42) minus the characters in the original code representation (23, just like in the first part of this puzzle) is 42 - 23 = 19.

 */
public class day8_2 {

    public static void main(String[] args) throws Exception {

        String inputFile = day8_2.class.getClassLoader().getResource("input8.txt").getFile();

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        int sum = 0;
        String s;
        while ((s = in.readLine()) != null) {

            int stringValue = processString(s);
            sum += stringValue;

        }

        System.out.println(sum);

    }

    public static int processString(String str) {

        //"aaa\"aaa"
        //"\"aaa\\\"aaa\""

        int lettersCount = 2; //first and last "

        char[] array = str.toCharArray();

        for (int i = 0; i < array.length; i++) {

            if (array[i] == '\\' || array[i] == '\"') {
                lettersCount += 2;
            } else {
                lettersCount++;
            }
        }

        return lettersCount - str.length();
    }
}

