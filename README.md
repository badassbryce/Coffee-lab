# Coffee-lab
School lab for a coffee ordering system

The system is created to be used by potential coffee stores. The system is created so customers can order and customize their coffee and set up a pickup. The system also keeps track of your inventory.
You can load your inventory data into the system, and everytime an order deleptes an item in the inventory. The system automatically substracts the item from your inventory. The customer can also set up 
a same day pickup order so they can pick a branch where they want to pickup the coffee order from.

BlackCoffee.java
Black coffee is a base coffee class that will have coffee decorators added to it.

Coffee.java
Coffee.java is an interface that is inherited by the base coffe classes such as BlackCoffee and Espresso.

CoffeeDecorator.java
This is an abstract class that will be extended by other decorators such as WithSugar.java.

Espresso.java
Espresso is a base coffee class that will have coffee decorators added to it.

Main.java
Main has the user inferface for the users to use and create orders

PickUpLocation.java
This class allows the user to setup pickup time and location

WithFlavor.java,WithHotWater.java,WithMilk.java,WithSugar.java,WithWhippedCream.java,
The classes above are the decorators which will be used on the base coffee class

Instructions:
When you run main the inferface will load. There you will see  5 options.
new order
reload inventory
update inventory
update log entry
and exit order
new order will take you to the order menu, update inventory will load the inventory to the system. The invenotry will already automatically load this option is here if you want to manually load it.
update inventory will update your inventory file with th new amounts from the system. Update log entry will update the file of your order history. 
and exit order will exit the user inferface and automatically update your inventory.
