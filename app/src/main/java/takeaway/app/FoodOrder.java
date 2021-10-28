package takeaway.app;

import java.util.HashMap;
import java.util.Map;

public class FoodOrder {
    private Map<String, Double> menu;
    private Map<String, Double> basket = new HashMap<>();

    public FoodOrder(RestaurantMenu menu) {
        this.menu = menu.getMenuItems();
    }

    public String addToBasket(String item) {
        for(Map.Entry<String, Double> pair : menu.entrySet()) {
            if (pair.getKey().equals(item)) {
                basket.put(pair.getKey(), pair.getValue());
                return pair.getKey() + " has been added to your basket.";
            }
        }
        return "This item does not exist on the menu.";
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

    public boolean isCorrectTotal(Double price) {
        return price.equals(getTotal());
    }

    public static void main(String[] args) {
        RestaurantMenu menu = new RestaurantMenu();
        FoodOrder order = new FoodOrder(menu);
        System.out.println(order.addToBasket("fried snapper"));
        System.out.println(order.addToBasket("plain rice"));
        System.out.println(order.addToBasket("chips"));
    }
}
