package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 --- Part Two ---

 The elves are also running low on ribbon. Ribbon is all the same width, so they only have to worry about the length they need to order, which they would again like to be exact.

 The ribbon required to wrap a present is the shortest distance around its sides, or the smallest perimeter of any one face. Each present also requires a bow made out of ribbon as well; the feet of ribbon required for the perfect bow is equal to the cubic feet of volume of the present. Don't ask how they tie the bow, though; they'll never tell.

 For example:

 A present with dimensions 2x3x4 requires 2+2+3+3 = 10 feet of ribbon to wrap the present plus 2*3*4 = 24 feet of ribbon for the bow, for a total of 34 feet.
 A present with dimensions 1x1x10 requires 1+1+1+1 = 4 feet of ribbon to wrap the present plus 1*1*10 = 10 feet of ribbon for the bow, for a total of 14 feet.

 How many total feet of ribbon should they order?

 */
public class day2_2 {

    public static void main(String[] args) throws Exception {

        String inputFile = day2_2.class.getClassLoader().getResource("input2.txt").getFile();

        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        int sum = 0;

        String s;
        while ((s = in.readLine()) != null) {

            int ind1 = s.indexOf('x');
            int h = Integer.parseInt(s.substring(0, ind1));

            String s1 = s.substring(ind1+1);
            int ind2 = s1.indexOf('x');

            int w = Integer.parseInt(s1.substring(0, ind2));
            int l = Integer.parseInt(s1.substring(ind2+1));

            int[] a = {l, w, h};
            Arrays.sort(a);

            int p = 2 * (a[0] + a[1])  + (a[0] * a[1] * a[2]);

            sum += p;

        }

        System.out.println(sum);
    }

}
