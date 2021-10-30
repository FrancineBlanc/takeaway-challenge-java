package takeaway.app;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MenuTest {

    RestaurantMenu menu;
    @Before
    public void initialise() {
        menu = new RestaurantMenu();
    }

    @Test
    public void testHasListOfDishesWithPrices() {
        assertEquals(8, menu.getMenuItems().size());
    }

    @Test
    public void testReturnsAParticularMenuItem() {
        Map<String, Double> choice = menu.getSelection("fried plantain");
        assertThat(choice, hasKey("fried plantain"));
        assertThat(choice, hasValue(2.00));
    }

    @Test
    public void testReturnsMenuAsString() {
        assertEquals("plain rice: £2.50;\n" +
                "fried plantain: £2.00;\n" +
                "ackee with sweet peppers: £6.00;\n" +
                "curried goat: £7.50;\n" +
                "fried snapper: £7.00;\n" +
                "fried chicken: £6.50;\n" +
                "rice and peas: £3.00;\n" +
                "mac and cheese: £4.00", menu.toString());
    }
}
