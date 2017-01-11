package shopping_management;

public class Item {
  private String name;
  private double price;
  private Boolean bogof;

  public Item(String name, double price, Boolean bogof) {
    this.name = name;
    this.price = price;
    this.bogof = bogof;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public Boolean getBogof() {
    return bogof;
  }

}