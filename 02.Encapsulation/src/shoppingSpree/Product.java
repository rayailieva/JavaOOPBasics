package shoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
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

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
