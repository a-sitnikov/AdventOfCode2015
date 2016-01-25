package day10;

/**
 --- Part Two ---

 Neat, right? You might also enjoy hearing John Conway talking about this sequence (that's Conway of Conway's Game of Life fame).

 Now, starting again with the digits in your puzzle input, apply this process 50 times. What is the length of the new result?

 Your puzzle input is 1113122113.
 */
public class day10_2 {

    public static void main(String[] args) throws Exception {

        String str = "1113122113";
        for (int i = 0; i < 50; i++) {
            str = getNextString(str);
        }

        System.out.println(str.length());
    }

    public static String getNextString(String str) {

        char currentDigit = ' ';
        int digitCount = 0;
        StringBuilder result = new StringBuilder(1024);

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if (c != currentDigit) {
                if (i > 0) {
                    result.append(String.valueOf(digitCount));
                    result.append(currentDigit);
                }
                currentDigit = c;
                digitCount = 1;
            } else {
                digitCount++;
            }

        }

        result.append(String.valueOf(digitCount));
        result.append(currentDigit);

        return result.toString();
    }

}
