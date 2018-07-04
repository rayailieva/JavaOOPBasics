package cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        this.stars += tuneIndex;
    }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) {
        this.stars = 0;
    }

    @Override
    public String toString() {
        StringBuilder showCarCB = new StringBuilder(super.toString());
        showCarCB.append(String.format("%d *", this.stars));

        return showCarCB.toString();
    }
}
