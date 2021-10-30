package takeaway.app;

import java.util.HashMap;
import java.util.Map;

public class FoodOrder {
    private RestaurantMenu menu;
    private Map<String, Integer> basket = new HashMap<>();

    public FoodOrder(RestaurantMenu menu) {
        this.menu = menu;
    }

    public void addToBasket(String item) {
        Integer quantity = basket.get(item);
        for(Map.Entry<String, Double> pair : menu.getSelection(item).entrySet()) {
            if (quantity == null) {
                basket.put(pair.getKey(), 1);
            } else {
                basket.put(pair.getKey(), quantity + 1);
            }
        }
    }

    public Map<String, Integer> getBasket() {
        return this.basket;
    }

    public Double getTotal() {
        Double total = 0.00;
        for (Map.Entry<String, Integer> pair : basket.entrySet()) {
            if (menu.getMenuItems().containsKey(pair.getKey())) {
                total += (menu.getMenuItems().get(pair.getKey()) * pair.getValue());
            }
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
