package foodShortage;

public class Rebel implements Buyer{
    private String name;
    private int age;
    private String group;
    private int foodAmount = 0;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void buyFood() {
        this.foodAmount += 5;
    }

    @Override
    public int getFood() {
        return this.foodAmount;
    }
}
