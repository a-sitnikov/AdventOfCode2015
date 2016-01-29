package day13;

/**
 * Created by msk5446 on 29.01.2016.
 */
public class Struct {

    public String name1;
    public String name2;
    public int happiness;

    public Struct(String str) {

        //Alice would gain 54 happiness units by sitting next to Bob.
        //Alice would lose 79 happiness units by sitting next to Carol.

        String[] array = str.split(" ");
        this.name1 = array[0];

        String name2 = array[array.length-1];
        this.name2 = name2.substring(0, name2.length() - 1);
        this.happiness = Integer.valueOf(array[3]);

        if (array[2].equals("lose")) this.happiness = -this.happiness;
    }

}
