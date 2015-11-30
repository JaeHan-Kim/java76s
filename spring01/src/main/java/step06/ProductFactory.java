package step06;

public class ProductFactory {
  public static Product createproduct(String type) {
    Product product = new Product();
    
    switch (type) {
    case "A":
      product.name="A";
      product.price=200000;
      break;
    case "B":
      product.name="B";
      product.price=150000;
      break;
    case "C":
      product.name="C";
      product.price=100000;
      break;
    }
    return product;
  }
}
