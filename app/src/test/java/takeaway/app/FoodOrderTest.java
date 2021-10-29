package takeaway.app;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FoodOrderTest {
    RestaurantMenu mockedMenu;
    FoodOrder foodOrder;

    @Before
    public void initialise() {
        Map<String, Double> testItems = new HashMap<>();
        testItems.put("test1", 2.00);
        testItems.put("test2", 3.00);
        testItems.put("test3", 1.00);

        mockedMenu = mock(RestaurantMenu.class);
        when(mockedMenu.getMenuItems()).thenReturn(testItems);

        foodOrder = new FoodOrder(mockedMenu);
        foodOrder.addToBasket("test1");
        foodOrder.addToBasket("test3");
    }
    @Test
    public void testMenuItemsAreAddedToABasket() {
        assertEquals(foodOrder.getBasket().size(), 2);
        assertEquals(foodOrder.getBasket().get("test1"), Double.valueOf(2.00));
    }

    @Test
    public void testTheTotalIsReturned() {
        assertEquals(foodOrder.getTotal(), Double.valueOf(3.00));
    }

    @Test
    public void testTotalMatchesTotalInBasket() {
        assertTrue(foodOrder.isCorrectTotal(3.00));
        assertFalse(foodOrder.isCorrectTotal(7.00));
    }

}
