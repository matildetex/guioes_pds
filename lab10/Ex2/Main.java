package lab10.Ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        System.out.println("\nStarting Matilde e Carolina's Restaurant....\n");
        List<String> orders = new ArrayList<>();
        
        orders.add("veggie burger");
        orders.add("Pasta Carbonara");
        orders.add("PLAIN pizza, no toppings!");
        orders.add("sushi nigiri and sashimi");
        orders.add("salad with tuna");
        orders.add("strawberry ice cream and waffles dessert");

        Chef Chef = new SushiChef().setsuccessor(new PastaChef()
                    .setsuccessor(new BurgerChef().setsuccessor(
                    new PizzaChef().setsuccessor(new DessertChef()))));

        for (String order : orders) {
            System.out.println("Can I please get a " + order + "?");
            Chef.handleRequest(order);
            System.out.println();
        }

    }
}
