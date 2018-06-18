package shoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
   private String name;
   private double money;
   private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name.equals("") || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
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
        return Collections.unmodifiableList(this.products);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addToCart(Product product){
        if(product.getCost() <= this.getMoney()){
            this.products.add(product);
            this.setMoney(this.getMoney() - product.getCost());
            System.out.println(this.getName() + " bought " + product.getName());
        }else{
            System.out.println(this.getName() + " can't afford " + product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" - ");

        if (this.getProducts().size() == 0) {
            sb.append("Nothing bought");

            return sb.toString();
        }

        for (Product product : this.getProducts()) {
            sb.append(product).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);

        return sb.toString();
    }
}
