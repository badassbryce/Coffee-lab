import java.util.ArrayList;
import java.util.List;
/**
 * @author Yunis Tamang
 */

public class BlackCoffee implements Coffee {
    /**
     * method to get price of coffee
     * @Return 1.0 which is price of black coffee
     */
    @Override
    public double getCost() {
        return 1.0;

    }
    /**
     * Method to get ArrayList of ingredients for this coffee
     * @return Ingredient arraylist
     */
    @Override
    public List<String> getIngredients() {
        List<String> Ingredients = new ArrayList<>();
        Ingredients.add("Black Coffee");
        return Ingredients;
    }
    /**
     * method to return an espresso string
     * @return "An espresso" string
     */
    @Override
    public String printCoffee() {
        return "A black coffee";
    }
}
