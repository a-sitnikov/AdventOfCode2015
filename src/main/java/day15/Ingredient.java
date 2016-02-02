package day15;

/**
 * Created by msk5446 on 02.02.2016.
 */
public class Ingredient {

    int capacity;
    int durability;
    int flavor;
    int texture;
    int calories;
    String name;

    public Ingredient(String str) {

        //Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8

        String[] array1 = str.split(":");
        this.name = array1[0];

        String[] array2 = array1[1].split(",");

        for (String s: array2) {

            String[] array3 = s.trim().split(" ");
            if (array3[0].equals("capacity")) {
                this.capacity = Integer.valueOf(array3[1]);

            } else if (array3[0].equals("durability")) {
                this.durability = Integer.valueOf(array3[1]);

            } else if (array3[0].equals("flavor")) {
                this.flavor = Integer.valueOf(array3[1]);

            } else if (array3[0].equals("texture")) {
                this.texture = Integer.valueOf(array3[1]);

            } else if (array3[0].equals("calories")) {
                this.calories = Integer.valueOf(array3[1]);

            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getFlavor() {
        return flavor;
    }

    public void setFlavor(int flavor) {
        this.flavor = flavor;
    }

    public int getTexture() {
        return texture;
    }

    public void setTexture(int texture) {
        this.texture = texture;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
