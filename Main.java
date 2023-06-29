import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.io.FileNotFoundException;

/**
 * @author Yunis Tamang
 */

public class Main {
    private static Map<String, Integer> inventory = new TreeMap<String, Integer>();
    private static List<CoffeeOrder> orders = new ArrayList<CoffeeOrder>();
    private static String logFile = "OrderLog.txt";
    private static String inventoryFile = "Inventory.txt";

    public static void main(String[] args) {

        System.out.println("Welcome to Java Coffee Co.!");
        try (Scanner input = new Scanner(System.in)) {
            inventory = readInventory(inventoryFile);
            System.out.println(inventory);
            boolean addOrder = true;
            do {

                System.out.println("1Enter digit of the action you would like to perform: ");
                System.out.println("1. New order");
                System.out.println("2. Reload Inventory");
                System.out.println("3. Update Inventory");
                System.out.println("4. Update Order Log enter");
                System.out.println("5. Exit Enter");


                String userin = input.nextLine();
                switch (userin) {
                    case "1":
                        CoffeeOrder order = buildOrder();
                        orders.add(order);
                        System.out.println(order.printOrder());
                        break;
                    case "2":
                        readInventory(inventoryFile);
                        break;
                    case "3":
                        writeInventory(inventoryFile);
                        break;
                    case "4":
                        writeOrderLog(logFile);
                        break;
                    case "5":
                        addOrder = false;
                        break;
                    default:
                        System.out.println("Your input is incorrect, please input a suitable digit");
                }
            } while (addOrder);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (orders.size() > 0) writeOrderLog(logFile);
    }

    /**
     * Builds orders of coffee with user input customization
     * @return returns order variable of CoffeeOrder type
     */
    private static CoffeeOrder buildOrder() {
        CoffeeOrder order = new CoffeeOrder();
        try {
            Scanner input = new Scanner(System.in);
            boolean addCoffee = true;
            while (addCoffee) {
                // prompt user to select base coffee type
                System.out.println("Select coffee type:");
                System.out.println("\t1. Black Coffee");
                System.out.println("\t2. Espresso");
                Coffee coffee;

                int option = 0;
                while (option < 1 || option > 2) {
                    if (!input.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        input.nextLine();
                    } else {
                        option = input.nextInt();
                        if (option < 1 || option > 2) System.out.println("Please enter a valid option.");
                    }
                }
                input.nextLine(); // nextInt() doesn't consume newline
                if (option == 2) {
                    // Espresso is a specific case
                    boolean holder = isInInventory("Espresso");
                    if(holder == false){
                        System.out.println("Sorry,we are out of Espresso.");
                        break;
                    }
                    coffee = new Espresso();
                } else {
                    // make BlackCoffee the default case
                    boolean holder = isInInventory("Black Coffee");
                    if(holder == false){
                        System.out.println("Sorry,we are out of Black Coffee.");
                        break;
                    }
                    coffee = new BlackCoffee();
                }

                // prompt user for any customizations
                while (option != 0) {
                    System.out.println(String.format("Coffee brewing: %s.", coffee.printCoffee()));
                    System.out.println("Would you like to add anything to your coffee?");
                    System.out.println("\t1. Flavored Syrup");
                    System.out.println("\t2. Hot Water");
                    System.out.println("\t3. Milk");
                    System.out.println("\t4. Sugar");
                    System.out.println("\t5. Whipped Cream");
                    System.out.println("\t0. NO - Finish Coffee");

                    while (!input.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        input.nextLine();
                    }
                    option = input.nextInt();
                    if(option == 1){
                        boolean a = isInInventory("MOCHA Syrup");
                        boolean b = isInInventory("CARAMEL Syrup");
                        boolean c = isInInventory("VANILLA Syrup");

                        if(a == false && b == false && c == false){
                            System.out.println("we are out of all Syrup");
                            continue;
                        }
                        if(a == false){
                            System.out.println("We are out of Mocha");
                        }
                        if(b == false){
                            System.out.println("We are out of Caramel");
                        }
                        if(c == false){
                            System.out.println("We are out of Vanilla");
                        }
                    }
                    if(option == 2){
                        boolean x = isInInventory("Hot Water");
                        if(x == false){
                            System.out.println("We are out of hot water.");
                            continue;
                        }
                    }
                    if(option == 3){
                        boolean x = isInInventory("Milk");
                        if(x == false){
                            System.out.println("We are out of Milk.");
                            continue;
                        }
                    }
                    if(option == 4){
                        boolean x = isInInventory("Sugar");
                        if(x == false){
                            System.out.println("We are out of sugar.");
                            continue;
                        }
                    }
                    if(option == 5){
                        boolean x = isInInventory("Whipped Cream");
                        if(x == false){
                            System.out.println("We are out of Whipped Cream.");
                            continue;
                        }
                    }

                    input.nextLine();
                    coffee = switch (option) {
                        case 1 -> {
                            System.out.println("Please select a flavor:");
                            for (WithFlavor.Syrup flavor : WithFlavor.Syrup.values()) {
                                System.out.println("\t" + String.format("%d. %s", flavor.ordinal() + 1, flavor));
                            }
                            int max = WithFlavor.Syrup.values().length;
                            option = 0;
                            while (option < 1 || option > max) {
                                if (!input.hasNextInt()) {
                                    System.out.println("Please enter a valid number.");
                                    input.nextLine();
                                } else {
                                    option = input.nextInt();
                                    if (option < 1 || option > max) System.out.println("Please enter a valid option.");
                                }
                            }
                            input.nextLine();
                            WithFlavor.Syrup flavor = WithFlavor.Syrup.values()[option - 1];
                            option = 1;

                            if (flavor == WithFlavor.Syrup.MOCHA){
                                inventory.put("MOCHA Syrup", inventory.get("MOCHA Syrup") - 1);
                            }
                            else if(flavor == WithFlavor.Syrup.CARAMEL){
                                inventory.put("CARAMEL Syrup", inventory.get("CARAMEL Syrup") - 1);
                            }
                            else if (flavor == WithFlavor.Syrup.VANILLA) {
                                inventory.put("VANILLA Syrup", inventory.get("VANILLA Syrup") - 1);
                            }
                            yield new WithFlavor(coffee, flavor);

                        }
                        case 2 -> {
                            inventory.put("Hot Water", inventory.get("Hot Water") - 1);
                            yield new WithHotWater(coffee);
                        }
                        case 3 ->{
                            inventory.put("Milk", inventory.get("Milk") - 1);
                            yield new WithMilk(coffee);
                        }
                        case 4 -> {
                            inventory.put("Sugar", inventory.get("Sugar") - 1);
                            yield new WithSugar(coffee);
                        }
                        case 5 -> {
                            inventory.put("Whipped Cream", inventory.get("Whipped Cream") - 1);
                            yield new WithWhippedCream(coffee);
                        }
                        default -> {
                            if (option != 0) System.out.println("Please enter valid option.");
                            yield coffee;
                        }
                    };
                }
                order.addCoffee(coffee);

                System.out.println("Would you like to order another coffee (Y or N)?");
                String yn = input.nextLine();
                while (!(yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y"))) {
                    System.out.println("Please enter Y or N.");
                    yn = input.nextLine();
                }
                addCoffee = !yn.equalsIgnoreCase("N");
                int newIn = 0;
                boolean selection = true;
                PickUpLocation.branches q;
                while(selection){
                    System.out.println("Where would you like to pickup the order?");
                    System.out.println("1. Coronado");
                    System.out.println("2. Hillcrest");
                    System.out.println("3. Carlsbad");
                    newIn = Integer.parseInt(input.nextLine());
                    switch (newIn) {
                        case 1:
                            q = PickUpLocation.branches.CORONADO;
                            selection = false;
                            break;
                        case 2:
                            q = PickUpLocation.branches.HILLSCREST;
                            selection = false;
                            break;
                        case 3:
                            q = PickUpLocation.branches.CALRSBAD;
                            selection = false;
                            break;
                        default:
                            System.out.println("please enter the correct input");
                    }
                }
                Calendar cal = Calendar.getInstance();
                Date d;
                selection = true;
                while(selection){
                    System.out.println("What time would you like to pick up your order today?");
                    System.out.print("please enter the hour between" +  LocalDateTime.MAX.getHour() + "and 21");
                    newIn = input.nextInt();

                    if(newIn <LocalDateTime.MAX.getHour() && newIn >21){
                        System.out.println("please enter a suitable time");
                    }
                    else{
                        cal.set(Calendar.HOUR_OF_DAY, newIn);
                        cal.set(Calendar.MINUTE,30);
                        cal.set(Calendar.SECOND,0);
                        cal.set(Calendar.MILLISECOND,0);
                        d = cal.getTime();
                        selection = true;
                    }
                }
                PickUpLocation done = order.setPickup(d,q);
                System.out.println("you can now pick up your order at the " + done.getPickUpLocation() + "branch at " + done.getPickupTime());
            }
        } catch (Exception e) {
            System.out.println("Error building order: " + e.getMessage());
        }

        return order;
    }

    /**
     *method reads the inventory found in a file and puts the content into a TreeMap
     * @param filePath
     * @return Returns TreeMap
     * @throws FileNotFoundException when file is not found
     */
    private static Map<String, Integer> readInventory(String filePath) throws FileNotFoundException {
        Map<String, Integer> invent = new TreeMap<String, Integer>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

           String line;
           while((line = reader.readLine()) != null){
                int equalHolder =  line.indexOf("=");
                String key = line.substring(0,(equalHolder - 1));
                String val = line.substring((equalHolder + 2));
                invent.put(key,Integer.parseInt(val));
           }
       }catch (Exception e){
           System.out.println("Error reading inventory: " + e.getMessage());
       }


        return invent;
    }

    /**
     * This method writes the inventory held in a TreeMap into a file
     * @param filePath
     */
    private static void writeInventory(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))){
            Set<Map.Entry<String,Integer> > entries = inventory.entrySet();
            for(Map.Entry<String, Integer> entry : entries){
                writer.write(entry.getKey() + " = " + entry.getValue());
                writer.newLine();
            }
        }catch (Exception e){
            System.out.println("Error writing inventory: " + e.getMessage());
        }finally {
            System.out.println("Inventory has been written successfully");
        }
    }

    /**
     * reads orderLog file
     * @param filePath
     * @return
     */
    private static List<CoffeeOrder> readOrderLog(String filePath) {
        return null;
    }

    /**
     * Writes Order into a file
     * @param filePath
     */
    private static void writeOrderLog(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (CoffeeOrder order : orders) {
                writer.write(order.printOrder());
                writer.newLine();
            }
            orders.clear();
        } catch (Exception e) {
            System.out.println("Error writing order log: " + e.getMessage());
        }finally {
            System.out.println("Log has been written successfully");
        }
    }

    /**
     * checks to see if items are in inventory or there are none left of the item
     * @param i
     * @return boolean
     */
    private static boolean isInInventory(String i) {
        boolean keyCheck = inventory.containsKey(i);
        if(keyCheck == true){
            int x = inventory.get(i);
            if(x > 0){
                return true;
            }
        }
        return false;
    }

    private static void updateOrderLog() {}
}