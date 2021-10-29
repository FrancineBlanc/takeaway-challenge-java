package takeaway.app;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;

public class MenuTest {

    @Test
    public void testHasListOfDishesWithPrices() {
        RestaurantMenu menu = new RestaurantMenu();
        assertEquals(menu.getMenuItems().size(), 8);
    }

    @Test
    public void testReturnsAParticularMenuItem() {
        RestaurantMenu menu = new RestaurantMenu();
        Map<String, Double> choice = menu.getSelection("fried plantain");
        assertThat(choice, hasKey("fried plantain"));

    }
}
