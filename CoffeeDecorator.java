import java.util.List;
/**
 * abstract class to extend from for all coffee decorators
 * @author Yunis Tamang
 */

public abstract class CoffeeDecorator implements Coffee {
    private Coffee coffee;

    /**
     * constructor that takes that base coffee to be decorated
     * @param c the base coffee to be decorated
     */
    public CoffeeDecorator(Coffee c) {
        coffee = c;
    }

    /**
     * Method to get the cost of the whole coffee
     * @return total cost of coffee double
     */
    public double getCost() { return coffee.getCost(); }

    /**
     * get the list of all ingredients in the coffee
     * @return arraylist of ingredients
     */
    public List<String> getIngredients() {
        return coffee.getIngredients();
    }

    /**
     * prints the string of everything that decorated the coffee
     * @return Returns method from Coffee
     */
    public String printCoffee() {
        return coffee.printCoffee();
    }
}
