package step06;

public class Product {
protected String name;
protected int price;
@Override
public String toString() {
  return "Product [name=" + name + ", price=" + price + "]";
}
public String getName() {
  return name;
}
public void setName(String name) {
  this.name = name;
}
public int getPrice() {
  return price;
}
public void setPrice(int price) {
  this.price = price;
}

}
