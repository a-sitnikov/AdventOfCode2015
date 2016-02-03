package day16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

/**
 --- Day 16: Aunt Sue ---

 Your Aunt Sue has given you a wonderful gift, and you'd like to send her a thank you card. However, there's a small problem: she signed it "From, Aunt Sue".

 You have 500 Aunts named "Sue".

 So, to avoid sending the card to the wrong person, you need to figure out which Aunt Sue (which you conveniently number 1 to 500, for sanity) gave you the gift. You open the present and, as luck would have it, good ol' Aunt Sue got you a My First Crime Scene Analysis Machine! Just what you wanted. Or needed, as the case may be.

 The My First Crime Scene Analysis Machine (MFCSAM for short) can detect a few specific compounds in a given sample, as well as how many distinct kinds of those compounds there are. According to the instructions, these are what the MFCSAM can detect:

 children, by human DNA age analysis.
 cats. It doesn't differentiate individual breeds.
 Several seemingly random breeds of dog: samoyeds, pomeranians, akitas, and vizslas.
 goldfish. No other kinds of fish.
 trees, all in one group.
 cars, presumably by exhaust or gasoline or something.
 perfumes, which is handy, since many of your Aunts Sue wear a few kinds.

 In fact, many of your Aunts Sue have many of these. You put the wrapping from the gift into the MFCSAM. It beeps inquisitively at you a few times and then prints out a message on ticker tape:

 children: 3
 cats: 7
 samoyeds: 2
 pomeranians: 3
 akitas: 0
 vizslas: 0
 goldfish: 5
 trees: 3
 cars: 2
 perfumes: 1

 You make a list of the things you can remember about each Aunt Sue. Things missing from your list aren't zero - you simply don't remember the value.

 What is the number of the Sue that got you the gift?
 */
public class Day16 {

    public static void main(String[] args) throws Exception {

        URL resource = Day16.class.getClassLoader().getResource("input16.txt");
        if (resource == null) {
            return;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            String s;
            ArrayList<Aunt> auntsList = new ArrayList<>();

            while ((s = in.readLine()) != null) {

                Aunt aunt = new Aunt(s);
                auntsList.add(aunt);

            }

            Aunt aunt = findAunt(auntsList, 3, 7, 2, 3, 0, 0, 5, 3, 2, 1);
            System.out.println(aunt);

            System.out.println("day 2");
            aunt = findAunt2(auntsList, 3, 7, 2, 3, 0, 0, 5, 3, 2, 1);
            System.out.println(aunt);
        }

    }

    public static Aunt findAunt(ArrayList<Aunt> auntsList, int children, int cats, int samoyeds, int pomeranians, int akitas,
                                int vizslas, int goldfish, int trees, int cars, int perfumes) {

        for (Aunt aunt: auntsList) {

            if ((aunt.children == null || aunt.children == children) &&
                    (aunt.cats == null || aunt.cats == cats) &&
                    (aunt.samoyeds == null || aunt.samoyeds == samoyeds) &&
                    (aunt.pomeranians == null || aunt.pomeranians == pomeranians) &&
                    (aunt.akitas == null || aunt.akitas == akitas) &&
                    (aunt.vizslas == null || aunt.vizslas == vizslas) &&
                    (aunt.goldfish == null || aunt.goldfish == goldfish) &&
                    (aunt.trees == null || aunt.trees == trees) &&
                    (aunt.cars == null || aunt.cars == cars) &&
                    (aunt.perfumes == null || aunt.perfumes == perfumes))
            {
                return aunt;
            }

        }

        return null;
    }

    public static Aunt findAunt2(ArrayList<Aunt> auntsList, int children, int cats, int samoyeds, int pomeranians, int akitas,
                                 int vizslas, int goldfish, int trees, int cars, int perfumes) {

        for (Aunt aunt: auntsList) {

            if ((aunt.children == null || aunt.children == children) &&
                    (aunt.cats == null || aunt.cats >= cats) &&
                    (aunt.samoyeds == null || aunt.samoyeds == samoyeds) &&
                    (aunt.pomeranians == null || aunt.pomeranians <= pomeranians) &&
                    (aunt.akitas == null || aunt.akitas == akitas) &&
                    (aunt.vizslas == null || aunt.vizslas == vizslas) &&
                    (aunt.goldfish == null || aunt.goldfish <= goldfish) &&
                    (aunt.trees == null || aunt.trees >= trees) &&
                    (aunt.cars == null || aunt.cars == cars) &&
                    (aunt.perfumes == null || aunt.perfumes == perfumes))
            {
                return aunt;
            }

        }

        return null;
    }
}
