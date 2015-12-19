package task4;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 --- Day 4: The Ideal Stocking Stuffer ---

 Santa needs help mining some AdventCoins (very similar to bitcoins) to use
 as gifts for all the economically forward-thinking little girls and boys.

 To do this, he needs to find MD5 hashes which, in hexadecimal, start with
 at least five zeroes. The input to the MD5 hash is some secret key (your
 puzzle input, given below) followed by a number in decimal. To mine
 AdventCoins, you must find Santa the lowest positive number (no leading
 zeroes: 1, 2, 3, ...) that produces such a hash.

 For example:

 If your secret key is abcdef, the answer is 609043, because the MD5
 hash of abcdef609043 starts with five zeroes (000001dbbfa...), and it
 is the lowest such number to do so.

 If your secret key is pqrstuv, the lowest number it combines with to
 make an MD5 hash starting with five zeroes is 1048970; that is, the
 MD5 hash of pqrstuv1048970 looks like 000006136ef....
 */
public class task4_2 {

    public static void main(String[] args) throws Exception {

        String secretKey = "iwrupvqb";

        int i = 1;
        do {
            String message = secretKey + Integer.toString(i);
            String messageMD5 = MD5(message);
            if (messageMD5.substring(0, 6).equals("000000")) {
                System.out.println("Number: " + i);
                System.out.println(messageMD5);
                break;
            }

            if (i % 500000 == 0) {
                System.out.println(i);
            }
            i++;
        } while (i < 1000000000);

    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
