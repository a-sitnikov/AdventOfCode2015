package day11;

import java.util.HashSet;

/**
 --- Day 11: Corporate Policy ---

 Santa's previous password expired, and he needs help choosing a new one.

 To help him remember his new password after the old one expires, Santa has devised a method of coming up with a password based on the previous one. Corporate policy dictates that passwords must be exactly eight lowercase letters (for security reasons), so he finds his new password by incrementing his old password string repeatedly until it is valid.

 Incrementing is just like counting with numbers: xx, xy, xz, ya, yb, and so on. Increase the rightmost letter one step; if it was z, it wraps around to a, and repeat with the next letter to the left until one doesn't wrap around.

 Unfortunately for Santa, a new Security-Elf recently started, and he has imposed some additional password requirements:

 Passwords must include one increasing straight of at least three letters, like abc, bcd, cde, and so on, up to xyz. They cannot skip letters; abd doesn't count.
 Passwords may not contain the letters i, o, or l, as these letters can be mistaken for other characters and are therefore confusing.
 Passwords must contain at least two different, non-overlapping pairs of letters, like aa, bb, or zz.

 For example:

 hijklmmn meets the first requirement (because it contains the straight hij) but fails the second requirement requirement (because it contains i and l).
 abbceffg meets the third requirement (because it repeats bb and ff) but fails the first requirement.
 abbcegjk fails the third requirement, because it only has one double letter (bb).
 The next password after abcdefgh is abcdffaa.
 The next password after ghijklmn is ghjaabcc, because you eventually skip all the passwords that start with ghi..., since i is not allowed.

 Given Santa's current password (your puzzle input), what should his next password be?

 Your puzzle input is cqjxjnds.

 --- Part Two ---

 Santa's password expired again. What's the next one?

 */
public class day11 {

    public static void main(String[] args) throws Exception {

        String str = "cqjxjnds";

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        int[] password = new int[str.length()];
        HashSet<Integer> deniedLetters = new HashSet<>();
        deniedLetters.add(alphabet.indexOf('i'));
        deniedLetters.add(alphabet.indexOf('o'));
        deniedLetters.add(alphabet.indexOf('l'));

        for (int i = 0; i < password.length; i++) {
            char c = str.charAt(i);
            password[password.length - (i + 1)] = alphabet.indexOf(c);
        }

        System.out.println(passwordToString(password, alphabet));

        getNextStrongPassword(password, alphabet.length() - 1, deniedLetters);
        System.out.println("part 1");
        System.out.println(passwordToString(password, alphabet));

        getNextStrongPassword(password, alphabet.length() - 1, deniedLetters);
        System.out.println("part 2");
        System.out.println(passwordToString(password, alphabet));
    }

    public static boolean isStrongPassword(int[] password) {

        boolean firstReq = false;
        for (int i = 2; i < password.length; i++) {
            // reverse order
            if (password[i-2] - password[i-1] == 1 && password[i-1] - password[i] == 1) {
                firstReq = true;
                break;
            }
        }

        if (!firstReq) return false;

        boolean thirdReq = false;
        for (int i = 1; i < password.length; i++) {
            if (password[i-1] == password[i]) {

                for (int j = i+2; j < password.length; j++) {
                    if (password[j-1] == password[j]) {
                        thirdReq = true;
                    }
                }
            }
        }


        return thirdReq;
    }

    public static void getNextPassword(int[] password, int max, HashSet<Integer> deniedLetters) {

        int i = 0;
        while (true) {
            password[i]++;
            if (deniedLetters.contains(password[i])) {
                password[i]++;
            }
            if (password[i] > max) {
                password[i] = 0;
                i++;
            } else {
                break;
            }
        }

    }

    public static void getNextStrongPassword(int[] password, int max, HashSet<Integer> deniedLetters) {

        int i = 0;

        while (true) {

            i++;

            getNextPassword(password, max, deniedLetters);
            if (isStrongPassword(password)) {
                break;
            }

            if (i == 1000000) {
                break;
            }

        }

    }

    public static String passwordToString(int[] password, String alphabet) {

        StringBuilder s = new StringBuilder(password.length);

        for (int i = 0; i < password.length; i++) {
            int ind = password[password.length - (i + 1)];
            s.append(alphabet.charAt(ind));
        }

        return s.toString();
    }

}

