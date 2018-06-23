package vehiclesExtension;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumptionPerKM, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKM, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionPerKM(double fuelConsumptionPerKM) {
        super.setFuelConsumptionPerKM(fuelConsumptionPerKM + 0.9);
    }

    @Override
    public boolean hasEnoughFuelIfFull(double distanceOrFuel) {
        return false;
    }

    @Override
    public void driveFull(double distanceOrFuel) {

    }
}
