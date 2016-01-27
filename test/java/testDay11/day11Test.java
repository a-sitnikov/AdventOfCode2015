package testDay11;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class day11Test {

    @Test
    public void testGetNextStrongPassword() throws Exception {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        HashSet<Integer> deniedLetters = new HashSet<>();
        deniedLetters.add(alphabet.indexOf('i'));
        deniedLetters.add(alphabet.indexOf('o'));
        deniedLetters.add(alphabet.indexOf('l'));

        int[] password = day11.day11.stringToPassword("ghijklmn", alphabet);

        day11.day11.getNextStrongPassword(password, alphabet.length() - 1, deniedLetters);

        String value = day11.day11.passwordToString(password, alphabet);

        assertEquals("ghjaabcc", value);

    }

    @Test
    public void testGetNextPassword() throws Exception {

    }

}