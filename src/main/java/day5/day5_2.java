package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

/**
 --- Part Two ---

 Realizing the error of his ways, Santa has switched to a better model of determining whether a string is naughty or nice. None of the old rules apply, as they are all clearly ridiculous.

 Now, a nice string is one with all of the following properties:

 It contains a pair of any two letters that appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
 It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe), or even aaa.

 For example:

 qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj) and a letter that repeats with exactly one letter between them (zxz).
 xxyxx is nice because it has a pair that appears twice and a letter that repeats with one between, even though the letters used by each rule overlap.
 uurcxstgmygtbstg is naughty because it has a pair (tg) but no repeat with a single letter between them.
 ieodomkazucvgmuy is naughty because it has a repeating letter with one between (odo), but no pair that appears twice.

 How many strings are nice under these new rules?


 */
public class Day5_2 {

    public static void main(String[] args) throws Exception {

        URL resource = Day5_1.class.getClassLoader().getResource("input5.txt");
        if (resource == null) {
            return;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            String s;
            int sum = 0;
            while ((s = in.readLine()) != null) {

                if (isNiceString(s)) {
                    //System.out.println(s);
                    sum++;
                    //break;
                }

            }

            System.out.println(sum);

        }

    }

    public static boolean isNiceString(String str) {

        char[] charArray = str.toCharArray();
        return isContainsDouble(charArray) && isContainsRepeating(charArray);
    }

    public static boolean isContainsDouble(char[] charArray) {

        for (int i = 1; i < charArray.length; i++) {

            String str2 = String.valueOf(new char[]{charArray[i-1], charArray[i]});
            for (int j = i + 2; j < charArray.length; j++) {
                String str2_1 = String.valueOf(new char[]{charArray[j-1], charArray[j]});
                if (str2.equals(str2_1)) {
                    return true;
                }
            }

        }

        return false;
    }

    public static boolean isContainsRepeating(char[] charArray) {

        for (int i = 2; i < charArray.length; i++) {

            if (charArray[i-2] == charArray[i]) {
                return true;
            }

        }

        return false;
    }
}
