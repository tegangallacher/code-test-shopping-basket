import static org.junit.Assert.*;
import org.junit.*;
import shopping_management.*;

public class ItemTest {

Item item;

@Before
public void before() {
  item = new Item("wine", 7.0, false);
}

@Test
public void hasName(){
  assertEquals("wine", item.getName());
}

@Test
public void hasPrice() {
  assertEquals(7.0, item.getPrice(), 0.1);
}

@Test
public void hasBogofBoolean() {
  assertEquals(false, item.getBogof());
}

}