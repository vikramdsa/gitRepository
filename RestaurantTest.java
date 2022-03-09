import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE

    @BeforeEach
    public void initialise_restaurant_object(){
        LocalTime openingTime = LocalTime.parse("08:00:00");
        LocalTime closingTime = LocalTime.parse("23:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
        restaurant.addToOrder("Vegetable lasagne",319);
        restaurant.addToOrder("Chicken lasagne",419);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        assertTrue(restaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        LocalTime openingTime = LocalTime.parse("00:00:00");
        LocalTime closingTime = LocalTime.parse("00:00:01");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        assertFalse(restaurant.isRestaurantOpen());
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //<<<<<<<<<<<<<<<<<<<<<<<OrderValue>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test
    public void adding_orderitem_to_orderlist_should_increase_orderlist_size_by_1(){
        int initialorderlistSize = restaurant.getOrderItemList().size();
        restaurant.addToOrder("Sizzling brownie",319);
        assertEquals(initialorderlistSize+1,restaurant.getOrderItemList().size());
    }
    @Test
    public void removing_orderitem_from_orderlist_should_decrease_orderlist_size_by_1() throws orderItemNotFoundException {
        int initialorderlistSize = restaurant.getOrderItemList().size();
        restaurant.removeFromOrder("Vegetable lasagne");
        assertEquals(initialorderlistSize-1,restaurant.getOrderItemList().size());
    }
    @Test
    public void removing_orderitem_that_does_not_exist_should_throw_exception() {
        assertThrows(orderItemNotFoundException.class,
                ()->restaurant.removeFromOrder("French fries"));
    }

    @Test
    public void get_order_value_from_orderlist() {
        assertEquals(738,restaurant.orderValue());
    }
   //<<<<<<<<<<<<<<<<<<<<<<<OrderValue>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}