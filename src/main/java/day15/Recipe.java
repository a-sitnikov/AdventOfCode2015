package day15;

import java.util.ArrayList;
import java.util.HashMap;

public class Recipe{

    ArrayList<Ingredient> ingredients = new ArrayList();
    ArrayList<Integer> ingredientAmount = new ArrayList<>();

    int totalIngredientAmount = 100;

    public int getScore() {

        return getCapacity() * getDurability() * getFlavor() * getTexture();
    }

    public int optimize() {

        ingredientAmount.set(ingredientAmount.size() - 1, getTotalIngredientAmount());
        int max = 0;
        do {
            int value = getScore();
            if (max < value) {
                max = value;
            }

        } while (next());

        return max;

    }

    public boolean next() {

        int i = 2; // second last from the end
        do {

            int value = ingredientAmount.get(ingredientAmount.size() - i);
            value += 1;

            if (value > getTotalIngredientAmount() - getAmountOfFirst(ingredientAmount.size() - i)) {
                ingredientAmount.set(ingredientAmount.size() - i, 0);
                i++;
            } else {
                ingredientAmount.set(ingredientAmount.size() - i, value);
                ingredientAmount.set(ingredientAmount.size() - 1, getTotalIngredientAmount() - getAmountOfFirst(ingredientAmount.size() - 1));
                return true;
            }

        } while (i <= ingredientAmount.size());

        return false;
    }

    public int getAmountOfFirst(int i) {

        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += ingredientAmount.get(j);
        }

        return sum;
    }

    public int getSize() {
        return ingredients.size();
    }

    public int getTotalIngredientAmount() {
        return totalIngredientAmount;
    }

    public void setTotalIngredientAmount(int totalIngredientAmount) {
        this.totalIngredientAmount = totalIngredientAmount;
    }

    public int getCapacity() {

        int capacity = 0;
        for (int i = 0; i < ingredients.size(); i++) {

            Ingredient ingredient = ingredients.get(i);
            int amount = ingredientAmount.get(i);

            capacity += ingredient.capacity * amount;
        }

        if (capacity < 0) {
            return 0;
        } else {
            return capacity;
        }
    }

    public int getDurability() {

        int durability = 0;
        for (int i = 0; i < ingredients.size(); i++) {

            Ingredient ingredient = ingredients.get(i);
            int amount = ingredientAmount.get(i);

            durability += ingredient.durability * amount;
        }

        if (durability < 0) {
            return 0;
        } else {
            return durability;
        }
    }

    public int getFlavor() {

        int flavor = 0;
        for (int i = 0; i < ingredients.size(); i++) {

            Ingredient ingredient = ingredients.get(i);
            int amount = ingredientAmount.get(i);

            flavor += ingredient.flavor * amount;
        }

        if (flavor < 0) {
            return 0;
        } else {
            return flavor;
        }
    }

    public int getTexture() {

        int texture = 0;
        for (int i = 0; i < ingredients.size(); i++) {

            Ingredient ingredient = ingredients.get(i);
            int amount = ingredientAmount.get(i);

            texture += ingredient.texture * amount;
        }

        if (texture < 0) {
            return 0;
        } else {
            return texture;
        }
    }

    public int getCalories() {

        int calories = 0;
        for (int i = 0; i < ingredients.size(); i++) {

            Ingredient ingredient = ingredients.get(i);
            int amount = ingredientAmount.get(i);

            calories += ingredient.calories * amount;
        }

        if (calories < 0) {
            return 0;
        } else {
            return calories;
        }
    }
}
