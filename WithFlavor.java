import java.util.List;
/**
 * @author Yunis Tamang
 */

public class WithFlavor extends CoffeeDecorator {
    private List<String> Ingredients;

    /**
     * Emun holding the various syrup flavors
     */
    enum Syrup {
        CARAMEL,
        MOCHA,
        VANILLA
    }

    private Syrup flavor;

    /**
     *Constructor for Flavor to decorate coffee
     * @param c holds the coffee to be decorated
     * @param s holds the syrup to be used to decorate the coffee
     */
    public WithFlavor(Coffee c, Syrup s) {
        super(c);
        flavor = s;
        Ingredients = super.getIngredients();
        switch(flavor){
            case MOCHA -> Ingredients.add("Mocha");
            case CARAMEL -> Ingredients.add("Caramel");
            case VANILLA -> Ingredients.add("Vanilla");
        }

    }

    /**
     * gets total cost of base coffee and the syrup added together
     * @return int
     */
    @Override
    public double getCost() {
        return super.getCost() + 0.35;
    }

    /**
     * gets the full list of ingredients of the coffee being decorated
     * @return Ingredients arraylist
     */
    @Override
    public List<String> getIngredients() {
        return Ingredients;
    }

    /**
     * prints everything the coffee has been decorated with including the flavor used
     * @return String
     */
    @Override
    public String printCoffee() {
        return super.printCoffee() + " with " + flavor;
    }
}
