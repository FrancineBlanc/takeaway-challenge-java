package takeaway.app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RestaurantMenu {
    private Map<String, Double> menuItems = new HashMap<String, Double>();

    public RestaurantMenu() {
        menuItems.put("curried goat", 7.50);
        menuItems.put("fried chicken", 6.50);
        menuItems.put("fried snapper", 7.00);
        menuItems.put("ackee with sweet peppers", 6.00);
        menuItems.put("fried plantain", 2.00);
        menuItems.put("mac and cheese", 4.00);
        menuItems.put("rice and peas", 3.00);
        menuItems.put("plain rice", 2.50);
    }

    public Map<String, Double> getMenuItems() {
        return menuItems;
    }

    public Map<String, Double> getSelection(String item) {
        Map<String, Double> chosenItems = new HashMap<>();
        for (Map.Entry<String, Double> pair : menuItems.entrySet()) {
            if (pair.getKey().equals(item)) {
                chosenItems.put(pair.getKey(), pair.getValue());
            }
        }
        return chosenItems;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<String, Double>> iterator = this.menuItems.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            builder.append(entry.getKey());
            builder.append(": £");
            builder.append(String.format("%.2f", entry.getValue()));
            if (iterator.hasNext()) {
                builder.append(";\n");
            }
        }
        return builder.toString();
    }
}
