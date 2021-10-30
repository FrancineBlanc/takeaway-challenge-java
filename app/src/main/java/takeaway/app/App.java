package takeaway.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        RestaurantMenu menu = new RestaurantMenu();
        FoodOrder order = new FoodOrder(menu);

        System.out.println("Welcome to Lucian flavours! Take a look at our menu:");
        System.out.println(menu.toString() + "\nPlease select some items from the menu and type 'exit' when you are done:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        while (true) {
            choice = reader.readLine();
            if (choice.equals("exit")) break;
            if (menu.getMenuItems().containsKey(choice)) {
                order.addToBasket(choice);
                System.out.println(choice + " added to basket");
            } else {
                System.out.println("This dish isn't available on the menu.");
            }
        }
        System.out.println("You have the following items in your basket: " + order.getBasket());
    }
}
