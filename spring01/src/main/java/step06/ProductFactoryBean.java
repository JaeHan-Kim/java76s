package step06;

import org.springframework.beans.factory.FactoryBean;

public class ProductFactoryBean implements FactoryBean<Product>{
 String type;
  
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  
  @Override
  public Product getObject() throws Exception {
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

  @Override
  public Class<?> getObjectType() {
    // TODO Auto-generated method stub
    return Product.class;
  }

  @Override
  public boolean isSingleton() {
    // TODO Auto-generated method stub
    return false;
  }
}
