package shoppingSpree;

import java.util.List;

public class Person {
   private String name;
   private double money;
   private List<Product> products;

    public Person(String name, double money, List<Product> products) {
        this.setName(name);
        this.setMoney(money);
        this.setProducts(products);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
