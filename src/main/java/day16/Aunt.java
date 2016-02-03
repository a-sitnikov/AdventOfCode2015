package day16;

public class Aunt {

    String name;
    Integer children;
    Integer cats;
    Integer samoyeds;
    Integer pomeranians;
    Integer akitas;
    Integer vizslas;
    Integer goldfish;
    Integer trees;
    Integer cars;
    Integer perfumes;

    public Aunt() {
    }

    @Override
    public String toString() {
        return "Aunt{" +
                "name='" + name + '\'' +
                '}';
    }

    public Aunt(String str) {

        int ind = str.indexOf(':');
        this.name = str.substring(0, ind);

        String[] array2 = str.substring(ind+1).split(",");

        for (String s: array2) {

            String[] array3 = s.trim().split(":");

            String propertyName = array3[0].trim();
            String propertyValue = array3[1].trim();

            if (propertyName.equals("children")) {
                this.children = Integer.valueOf(propertyValue);

            } else if (propertyName.equals("cats")) {
                this.cats = Integer.valueOf(propertyValue);

            } else if (propertyName.equals("samoyeds")) {
                this.samoyeds = Integer.valueOf(propertyValue);

            } else if (propertyName.equals("pomeranians")) {
                this.pomeranians = Integer.valueOf(propertyValue);

            } else if (propertyName.equals("akitas")) {
                this.akitas = Integer.valueOf(propertyValue);

            } else if (propertyName.equals("vizslas")) {
                this.vizslas = Integer.valueOf(propertyValue);

            } else if (propertyName.equals("goldfish")) {
                this.goldfish = Integer.valueOf(propertyValue);

            } else if (propertyName.equals("trees")) {
                this.trees = Integer.valueOf(propertyValue);

            } else if (propertyName.equals("cars")) {
                this.cars = Integer.valueOf(propertyValue);

            } else if (propertyName.equals("perfumes")) {
                this.perfumes = Integer.valueOf(propertyValue);

            }
        }
    }
}
