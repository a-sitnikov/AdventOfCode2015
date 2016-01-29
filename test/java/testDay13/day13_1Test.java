package testDay13;

import day13.Day13_1;
import day13.Struct;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.StringReader;

import static org.junit.Assert.*;


public class Day13_1Test {

    @Test
    public void processString() {

        Struct struct;
        struct= new Struct("Alice would gain 54 happiness units by sitting next to Bob.");
        assertEquals("Alice", struct.name1);
        assertEquals("Bob",   struct.name2);
        assertEquals(54,      struct.happiness);

        struct = new Struct("Alice would lose 79 happiness units by sitting next to Carol.");
        assertEquals("Alice", struct.name1);
        assertEquals("Carol", struct.name2);
        assertEquals(-79,     struct.happiness);

    }

    @Test
    public void testGetHappinessMap() throws Exception {

        StringBuilder s = new StringBuilder(1024);

        s.append("Alice would gain 54 happiness units by sitting next to Bob.").append("\n").
                append("Alice would lose 79 happiness units by sitting next to Carol.").append("\n").
                append("Alice would lose 2 happiness units by sitting next to David.").append("\n").
                append("Bob would gain 83 happiness units by sitting next to Alice.").append("\n").
                append("Bob would lose 7 happiness units by sitting next to Carol.").append("\n").
                append("Bob would lose 63 happiness units by sitting next to David.").append("\n").
                append("Carol would lose 62 happiness units by sitting next to Alice.").append("\n").
                append("Carol would gain 60 happiness units by sitting next to Bob.").append("\n").
                append("Carol would gain 55 happiness units by sitting next to David.").append("\n").
                append("David would gain 46 happiness units by sitting next to Alice.").append("\n").
                append("David would lose 7 happiness units by sitting next to Bob.").append("\n").
                append("David would gain 41 happiness units by sitting next to Carol.");

        BufferedReader in = new BufferedReader(new StringReader(s.toString()));
        int[][] happinessMap = Day13_1.getHappinessMap(in);

        int[][] value = new int[4][4];
        value[0] = new int[]{0,      54+83, -79-62, -2+46};
        value[1] = new int[]{54+83,      0,  -7+60, -63-7};
        value[2] = new int[]{-79-62, -7+60,      0, 55+41};
        value[3] = new int[]{-2+46,  -63-7,  55+41,     0};

        assertArrayEquals(value, happinessMap);

        Day13_1.peopleCount = 4;
        int max = Day13_1.getMaxHappiness(happinessMap);
        assertEquals(330, max);

    }
}