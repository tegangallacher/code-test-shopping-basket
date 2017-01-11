import shopping_management.*;
import org.junit.*;
import static org.junit.Assert.*;


public class BasketTest {

    Basket basket;
    Item item1;
    Item item2;
    Item item3;
    Item item4;
    Item item5;

    @Before
    public void before() {
        basket = new Basket();
        item1 = new Item ("Wine", 7.99, false);
        item2 = new Item ("Chocolate", 1.60, true);
        item3 = new Item ("Bread", 1.25, false);
        item4 = new Item ("Jeans", 27.50, false);
        item5 = new Item("Milk", 0.80, false);
    }

    @Test
    public void addItemToBasketTest() {
        basket.addItem(item1);
        assertEquals(1, basket.basketSize());
    }

//Also test is showing if bogof boolean = true then it counts basket size of two items
    @Test
    public void canRemoveItemFromBasketTest() {
        basket.addItem(item1);
        basket.addItem(item2);
        assertEquals(3, basket.basketSize());
        basket.removeItem(item2);
        assertEquals(1, basket.basketSize());
    }

    @Test 
    public void canEmptyBasketTest() {
      basket.addItem(item1);
      basket.addItem(item2);
      assertEquals(3, basket.basketSize());
      basket.emptyBasket();
      assertEquals(0, basket.basketSize());  
    }

    @Test
    public void getValueOfBasketTest() {
       basket.addItem(item1);
       basket.addItem(item3);
       basket.addItem(item5);
       assertEquals(3, basket.basketSize());
       assertEquals(10.04, basket.valueOfTotalBasket(), 0.01);
    }

//Adds extra item for bogof but only prices one to the total
    @Test
    public void fullBogofTest() {
       basket.addItem(item2);
       assertEquals(2, basket.basketSize());
       assertEquals(1.60, basket.valueOfTotalBasket(), 0.01);
    }

    @Test
    public void discountOverATotalOf20Test() {
        basket.addItem(item4);
        assertEquals(24.75, basket.valueOfTotalBasket(), 0.01);
    }

    @Test
    public void loyaltyCardTest() {
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);
        basket.addItem(item5);
        assertEquals(6, basket.basketSize());
        double total = basket.valueOfTotalBasket();
        assertEquals(34.52, basket.loyaltyDiscount(total), 0.01);

    }


}