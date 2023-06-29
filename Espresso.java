import java.util.ArrayList;
import java.util.List;

/**
 * Base coffee class of Espresso
 * @author Yunis Tamang
 */
public class Espresso implements Coffee {
    @Override
    /**
     * method to get price of coffee
     * @Return 1.75 which is price of Espresso
     */
    public double getCost() {
        return 1.75;
    }

    /**
     * Method to get ArrayList of ingredients for this coffee
     * @return Ingredient arraylist
     */
    @Override
    public List<String> getIngredients() {
        List<String> Ingredients = new ArrayList<>();
        Ingredients.add("Espresso");
        return Ingredients;
    }

    /**
     * method to return an espresso string
     * @return "An espresso" string
     */
    @Override
    public String printCoffee() {
        return "An espresso";
    }
}

