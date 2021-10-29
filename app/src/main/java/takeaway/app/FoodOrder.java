package takeaway.app;

import java.util.HashMap;
import java.util.Map;

public class FoodOrder {
    private RestaurantMenu menu;
    private Map<String, Double> basket = new HashMap<>();

    public FoodOrder(RestaurantMenu menu) {
        this.menu = menu;
    }

    public void addToBasket(String item) {
        for(Map.Entry<String, Double> pair : menu.getSelection(item).entrySet()) {
            basket.put(pair.getKey(), pair.getValue());
        }
    }

    public Map<String, Double> getBasket() {
        return this.basket;
    }

    public Double getTotal() {
        Double total = 0.00;
        for (Map.Entry<String, Double> pair : basket.entrySet()) {
            total += pair.getValue();
        }
        return total;
    }

    public String printTotal() {
        return String.format("Your total comes to £%.2f", getTotal());
    }

    public boolean isCorrectTotal(Double price) {
        return price.equals(getTotal());
    }

    public String placeOrder(TextClient client) {
        if (!basket.isEmpty()) {
            client.sendMessage();
            return "Your order has been successfully placed!";
        }
        return "You cannot place an order with an empty basket";
    }
}
