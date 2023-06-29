import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Yunis Tamang
 * The CoffeeOrder class holds the array that keeps all the customized coffees in one order, think of it as a order receipt
 */
public class CoffeeOrder {
    private List<Coffee> coffees;
    private LocalDateTime orderDate;

    /**
     * constructor for CoffeeOrder class
     */
    public CoffeeOrder() {
        coffees = new ArrayList<Coffee>();
        orderDate = LocalDateTime.now();
    }

    /**
     * Coffee order constructor that creates an order and saves the date and time
     * @param orderDate holds the date of the order
     */
    public CoffeeOrder(LocalDateTime orderDate) {
        coffees = new ArrayList<Coffee>();
        this.orderDate = orderDate;
    }

    /**
     * Method that adds coffee to the order arraylist
     * @param c holds the coffee to be added to the list
     */
    public void addCoffee(Coffee c) {
        coffees.add(c);
    }

    /**
     * getter for the list holding the coffees in the order
     * @return Arraylist coffees
     */
    public List<Coffee> getCoffees() { return coffees; }

    /**
     * gets the date and time of the order
     * @return LocalDateTime orderDate
     */
    public LocalDateTime getOrderDate() { return orderDate; }

    /**
     * getter for total cost of the coffees
     * @return Double total
     */
    public double getTotal() {
        double total = 0;
        for (Coffee coffee : coffees) {
            total += coffee.getCost();
        }
        return total;
    }

    /**
     * prints everything that has been ordered and put in the arraylist
     * @return String of everything in the order
     */
    public String printOrder() {
        StringBuilder order = new StringBuilder("ORDER RECEIPT\n");
        order.append(String.format("Timestamp: %s%n", orderDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mma"))));
        for (int i = 0; i < coffees.size(); i++) {
            Coffee coffee = coffees.get(i);
            order.append(String.format("Item %d: %s - %.2f%n", i + 1, coffee.printCoffee(), coffee.getCost()));
        }
        order.append(String.format("TOTAL = %.2f%n", getTotal()));
        return order.toString();
    }
    public PickUpLocation setPickup(Date T,PickUpLocation.branches L){
        PickUpLocation p = new PickUpLocation(T, L, coffees);
        return p;
    }
}
