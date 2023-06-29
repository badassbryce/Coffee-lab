import java.util.List;
/**
 * class for coffe decorator withWhippedCream
 * @author Yunis Tamang
 */

public class WithWhippedCream extends CoffeeDecorator {
    private List<String> Ingredients;
    /**
     * constructor for WithWhippedCream class and adds the customization to the coffee
     * @param c holds the coffee to be decorated
     */
    public WithWhippedCream(Coffee c) {
        super(c);
        Ingredients = super.getIngredients();
        Ingredients.add("Whipped Cream");
    }
    /**
     * Gets the total cost of the coffee
     * @return returns total cost of the coffee
     */
    @Override
    public double getCost() {
        return super.getCost() + 0.25;
    }
    /**
     * getter for the list of ingredients for the coffee
     * @return arraylist of ingredients
     */
    @Override
    public List<String> getIngredients() {
        return Ingredients;
    }
    /**
     * prints everything the coffee has been decorated with including the decorator used
     * @return String
     */
    @Override
    public String printCoffee() {
        return super.printCoffee() + " with whipped cream";
    }
}
