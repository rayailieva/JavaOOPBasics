package exam12March2017.cars;

import java.util.ArrayList;
import java.util.Collection;

public class PerformanceCar extends Car {
    private Collection<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        this.addOns.add(addOn);
    }

    @Override
    public void setHorsepower(int horsepower) {
        int increasedHorsepower = horsepower + ((horsepower * 50) / 100);
        super.setHorsepower(increasedHorsepower);
    }

    @Override
    public void setSuspension(int suspension) {
        int increasedSuspension = suspension - ((suspension * 25) / 100);
        super.setSuspension(increasedSuspension);
    }

    @Override
    public String toString() {
        StringBuilder performanceCarCB = new StringBuilder(super.toString());
        String addOns = this.addOns.size() == 0 ? "None" : String.join(", ", this.addOns);
        performanceCarCB.append(String.format("Add-ons: %s", addOns));

        return performanceCarCB.toString();
    }
}

