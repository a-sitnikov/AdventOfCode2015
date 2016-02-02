package day14;

import java.util.ArrayList;
import java.util.HashMap;

public class ReindeerHashMap extends HashMap<Reindeer, Integer> {

    public int getWinnerScoreAfter(int time) {

        for (int i = 1; i < time+1; i++) {

            ArrayList<Reindeer> leaders =  getLeaderEntryAfter(i);
            for (Reindeer leader: leaders) {
                this.put(leader, this.get(leader) + 1);
            }

        }

        int maxScore = 0;
        for (Entry<Reindeer, Integer> entry: this.entrySet()) {
            if (maxScore < entry.getValue()) {
                maxScore = entry.getValue();
            }
        }

        return maxScore;
    }

    public  ArrayList<Reindeer> getLeaderEntryAfter(int time) {

        HashMap<Reindeer, Integer> distanceHashMap = new HashMap<>();

        int maxDist = 0;
        for (Entry<Reindeer, Integer> entry: this.entrySet()) {

            int dist = entry.getKey().getDistanceAfter(time);
            distanceHashMap.put(entry.getKey(), dist);

            if (maxDist < dist) maxDist = dist;

        }

        ArrayList<Reindeer> leaders = new ArrayList<>();
        for (Entry<Reindeer, Integer> entry: distanceHashMap.entrySet()) {

            if (entry.getValue() == maxDist) {
                leaders.add(entry.getKey());
            }

        }

        return leaders;
    }
}
