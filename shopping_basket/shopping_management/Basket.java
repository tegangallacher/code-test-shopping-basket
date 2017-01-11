package shopping_management;
import java.util.*;

public class Basket {
  private ArrayList<Item> basket;

public Basket() {
  this.basket = new ArrayList<Item>();
}

// public ArrayList getBasket() {
//   return this.basket;
// }

public void addItem(Item item) {
  if (item.getBogof() == false) {
    basket.add(item);
  }
  else if (item.getBogof() == true) {
    basket.add(item);
    basket.add(item);
  }
}

public void removeItem(Item item) {
  if (item.getBogof() == false) {
    basket.remove(item);
  }
  else if (item.getBogof() == true) {
    basket.remove(item);
    basket.remove(item);
  }
}

public void emptyBasket() {
  basket.clear();
}

public int basketSize() {
  return basket.size();
}

public double valueOfTotalBasket() {
  double value = 0.00;
   for (Item item : this.basket) {
      if(item.getBogof() == false) {
        value += item.getPrice();
      }
      else if (item.getBogof() == true) {
        value += item.getPrice()/2;
      }
   }
      if (value >= 20.00) {
          value -= (value * 0.1) ;
      }
  return value;
}

public double loyaltyDiscount(double total) {
  return (total * 0.98);
}


}