package day14;

public class Reindeer {

    public String name;
    public int speed;
    public int movingTime;
    public int restTime;

    public Reindeer(String str) {

        //Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.

        String[] array = str.split(" ");
        this.name = array[0];
        this.speed = Integer.valueOf(array[3]);
        this.movingTime = Integer.valueOf(array[6]);
        this.restTime = Integer.valueOf(array[13]);

    }

    public int getDistanceAfter(int time) {

        int cycleTime = this.movingTime + this.restTime;
        int cyclesCount = time / cycleTime;
        int remainder = time - (cycleTime*cyclesCount);

        int remainderDist = Math.min(remainder, this.movingTime) * this.speed;

        return cyclesCount * this.speed * this.movingTime + remainderDist;

    }

    @Override
    public String toString() {
        return "Reindeer{" +
                "name='" + name + '\'' +
                '}';
    }
}
