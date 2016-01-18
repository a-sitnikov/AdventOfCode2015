package day8;

import day6.Action;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 --- Day 8: Matchsticks ---

 Space on the sleigh is limited this year, and so Santa will be bringing his list as a digital copy. He needs to know how much space it will take up when stored.

 It is common in many programming languages to provide a way to escape special characters in strings. For example, C, JavaScript, Perl, Python, and even PHP handle special characters in very similar ways.

 However, it is important to realize the difference between the number of characters in the code representation of the string literal and the number of characters in the in-memory string itself.

 For example:

 "" is 2 characters of code (the two double quotes), but the string contains zero characters.
 "abc" is 5 characters of code, but 3 characters in the string data.
 "aaa\"aaa" is 10 characters of code, but the string itself contains six "a" characters and a single, escaped quote character, for a total of 7 characters in the string data.
 "\x27" is 6 characters of code, but the string itself contains just one - an apostrophe ('), escaped using hexadecimal notation.

 Santa's list is a file that contains many double-quoted string literals, one on each line. The only escape sequences used are \\ (which represents a single backslash), \" (which represents a lone double-quote character), and \x plus two hexadecimal characters (which represents a single character with that ASCII code).

 Disregarding the whitespace in the file, what is the number of characters of code for string literals minus the number of characters in memory for the values of the strings in total for the entire file?

 For example, given the four strings above, the total number of characters of string code (2 + 5 + 10 + 6 = 23) minus the total number of characters in memory for string values (0 + 3 + 7 + 1 = 11) is 23 - 11 = 12.

 */
public class day8_1 {

    public static void main(String[] args) throws Exception {

        String inputFile = day8_1.class.getClassLoader().getResource("input8.txt").getFile();

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

        //"oqddwlvmtv\"\x39lyybylfb\"jmngnpjrdw"

        int lettersCount = 0;

        char[] array = str.toCharArray();
        if (array[0] != '\"') {
            lettersCount++;
        } else if (array[array.length - 1] != '\"') {
            lettersCount++;
        }

        for (int i = 1; i < array.length-1; i++) {

            if (array[i] == '\\') {

                if (array[i+1] == '\\' || array[i+1] == '\"'){
                    i++;
                } else if (array[i+1] == 'x') {
                    i += 3;
                }

            }

            lettersCount++;
        }

        return str.length() - lettersCount;
    }
}
