package takeaway.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testHasListOfDishesWithPrices() {
        RestaurantMenu menu = new RestaurantMenu();
        assertEquals(menu.getMenuItems().get("fried plantain"), Double.valueOf(2.00));
        assertEquals(menu.getMenuItems().size(), 8);
    }
}
