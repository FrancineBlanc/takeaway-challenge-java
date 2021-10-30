package takeaway.app;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FoodOrderTest {
    RestaurantMenu mockedMenu;
    FoodOrder foodOrder;

    @Test
    public void testDoesNotPlaceOrderIfBasketEmpty() {
        TextClient mockedTextClient = mock(TextClient.class);
        foodOrder = new FoodOrder(new RestaurantMenu());
        assertEquals("You cannot place an order with an empty basket", foodOrder.placeOrder(mockedTextClient));
    }

    @Before
    public void initialise() {
        Map<String, Double> testItems = new HashMap<>();
        testItems.put("test1", 2.00);
        testItems.put("test2", 3.00);
        testItems.put("test3", 1.00);

        mockedMenu = mock(RestaurantMenu.class);
        when(mockedMenu.getMenuItems()).thenReturn(testItems);
        when(mockedMenu.getSelection("test1")).thenCallRealMethod();
        when(mockedMenu.getSelection("test2")).thenCallRealMethod();

        foodOrder = new FoodOrder(mockedMenu);
        foodOrder.addToBasket("test1");
        foodOrder.addToBasket("test2");
    }
    @Test
    public void testMenuItemsAreAddedToABasket() {
        assertEquals(2, foodOrder.getBasket().size());
        assertEquals(Integer.valueOf(1), foodOrder.getBasket().get("test1"));
    }

    @Test
    public void testTheTotalIsReturned() {
        assertEquals(Double.valueOf(5.00), foodOrder.getTotal());
    }

    @Test
    public void testTotalMatchesTotalInBasket() {
        assertTrue(foodOrder.isCorrectTotal(5.00));
        assertFalse(foodOrder.isCorrectTotal(9.00));
    }

    @Test
    public void testPrintsContentsOfBasket() {
        assertEquals("item: test2, quantity: 1;\nitem: test1, quantity: 1", foodOrder.printBasket());
    }

    @Test
    public void testTotalPriceIsPrinted() {
        assertEquals("Your total comes to £5.00", foodOrder.printTotal());
    }

    @Test
    public void testPlaceOrder() {
        TextClient mockedTextClient = mock(TextClient.class);
        assertEquals("Your order has been successfully placed!", foodOrder.placeOrder(mockedTextClient));
    }
}
