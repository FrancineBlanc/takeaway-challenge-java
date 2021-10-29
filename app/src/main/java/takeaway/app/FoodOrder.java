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
        menu.getSelection(item);
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

    public void printTotal() {
        System.out.printf("Your total comes to £%.2f", getTotal());
    }

    public boolean isCorrectTotal(Double price) {
        return price.equals(getTotal());
    }

}
