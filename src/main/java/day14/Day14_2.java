package day14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

/**
 --- Part Two ---

 Seeing how reindeer move in bursts, Santa decides he's not pleased with the old scoring system.

 Instead, at the end of each second, he awards one point to the reindeer currently in the lead. (If there are multiple reindeer tied for the lead, they each get one point.) He keeps the traditional 2503 second time limit, of course, as doing otherwise would be entirely ridiculous.

 Given the example reindeer from above, after the first second, Dancer is in the lead and gets one point. He stays in the lead until several seconds into Comet's second burst: after the 140th second, Comet pulls into the lead and gets his first point. Of course, since Dancer had been in the lead for the 139 seconds before that, he has accumulated 139 points by the 140th second.

 After the 1000th second, Dancer has accumulated 689 points, while poor Comet, our old champion, only has 312. So, with the new scoring system, Dancer would win (if the race ended at 1000 seconds).

 Again given the descriptions of each reindeer (in your puzzle input), after exactly 2503 seconds, how many points does the winning reindeer have?

 */
public class Day14_2 {

    public static void main(String[] args) throws Exception {

        URL resource = Day14_1.class.getClassLoader().getResource("input14.txt");
        if (resource == null) {
            return;
        }

        try (BufferedReader in = new BufferedReader(new FileReader(resource.getFile()))) {

            String s;
            ReindeerHashMap reindeerHashMap = new ReindeerHashMap();

            while ((s = in.readLine()) != null) {

                Reindeer reindeer = new Reindeer(s);
                reindeerHashMap.put(reindeer, 0);

            }

            int score = reindeerHashMap.getWinnerScoreAfter(2503);
            System.out.println(score);

        }

    }
}
