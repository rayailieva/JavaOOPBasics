package foodShortage;

public class Citizen implements Identifiable, Living, Buyer {
    private String name;
    private int age;
    private String id;
    private String birthday;
    private int foodAmount = 0;

    public Citizen(String name, int age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public void buyFood() {
        this.foodAmount += 10;
    }

    @Override
    public int getFood() {
        return this.foodAmount;
    }
}
