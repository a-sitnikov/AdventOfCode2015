package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.Arrays;

/**
 --- Day 2: I Was Told There Would Be No Math ---

 The elves are running low on wrapping paper, and so they need to submit an order for more. They have a list of the dimensions (length l, width w, and height h) of each present, and only want to order exactly as much as they need.

 Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l. The elves also need a little extra paper for each present: the area of the smallest side.

 For example:

 A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper plus 6 square feet of slack, for a total of 58 square feet.
 A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper plus 1 square foot of slack, for a total of 43 square feet.

 All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?

 */
public class Day2_1 {

    public static void main(String[] args) throws Exception {

        URL resource = Day2_1.class.getClassLoader().getResource("input2.txt");
        if (resource == null) {
            return;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            int sum = 0;

            String s;
            while ((s = in.readLine()) != null) {

                int p = processString(s);
                sum += p;

            }

            System.out.println(sum);
        }
    }

    public static int processString(String str) {

        String[] array = str.split("x");

        int dim[] = new int[3];

        for (int i = 0; i < 3; i++) {
            dim[i] = Integer.parseInt(array[i]);
        }

        int[] a = {dim[0]*dim[1], dim[1]*dim[2], dim[2]*dim[0]};
        Arrays.sort(a);

        return 2 * (a[0] + a[1] + a[2]) + a[0];

    }
}
