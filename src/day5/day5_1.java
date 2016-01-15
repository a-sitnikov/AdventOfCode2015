package day5;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 --- Day 5: Doesn't He Have Intern-Elves For This? ---

 Santa needs help figuring out which strings in his text file are naughty or nice.

 A nice string is one with all of the following properties:

 It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
 It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
 It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.

 For example:

 ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
 aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
 jchzalrnumimnmhp is naughty because it has no double letter.
 haegwjzuvuyypxyu is naughty because it contains the string xy.
 dvszwmarrgswjxmb is naughty because it contains only one vowel.

 How many strings are nice?

 */
public class day5_1 {

    public static void main(String[] args) throws Exception {

        String inputFile = day5_1.class.getClassLoader().getResource("input5.txt").getFile();

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        String s;
        int sum = 0;
        while ((s = in.readLine()) != null) {

            if (isNiceString(s)) {
                sum++;
            }

        }

        System.out.println(sum);

    }

    public static boolean isNiceString(String str) {

        char[] charArray = str.toCharArray();
        int numOfVowels = 0;
        boolean isContainsDouble = false;
        for (int i = 0; i < charArray.length; i++) {

            char c = charArray[i];
            if (isVowel(c)) {
                numOfVowels++;
            }

            if (i > 0) {

                String str2 = String.valueOf(new char[]{charArray[i-1], charArray[i]});
                if (isForbiddenStr(str2)) {
                    return false;
                }

                if (charArray[i-1] == charArray[i]) {
                    isContainsDouble = true;
                }

            }

        }

        if (numOfVowels >= 3 && isContainsDouble) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isVowel(char c) {

        if (c == 'a' || c == 'e' || c =='i' || c =='o' || c == 'u') {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isForbiddenStr(String str) {

        // ab, cd, pq, or xy
        if (str.equals("ab") || str.equals("cd") || str.equals("pq") || str.equals("xy")) {
            return true;
        } else {
            return false;
        }
    }
}