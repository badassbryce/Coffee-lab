import java.util.List;
/**
 * Hot water class that decorates the coffee
 * @author Yunis Tamang
 */

public class WithHotWater extends CoffeeDecorator {

    private List<String> Ingredients;

    /**
     * constructor for WithHotWater class and adds the customization to the coffee
     * @param c holds the coffee to be decorated
     */
    public WithHotWater(Coffee c) {
        super(c);
    }

    /**
     * Gets the total cost of the coffee
     * @return returns total cost of the coffee
     */
    @Override
    public double getCost() {
        return super.getCost();
    }

    /**
     * getter for the list of ingredients for the coffee
     * @return arraylist of ingredients
     */
    @Override
    public List<String> getIngredients() {
        Ingredients = super.getIngredients();
        Ingredients.add("Hot Water");
        return Ingredients;
    }
    /**
     * prints everything the coffee has been decorated with including the decorator used
     * @return String
     */
    @Override
    public String printCoffee() {
        return super.printCoffee() + " with hot water";
    }
}
