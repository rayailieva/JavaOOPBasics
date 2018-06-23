package vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption; //in liters per km


    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);

    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void drive(double distance){
        double fuelNeeded = distance * this.fuelConsumption;
        this.fuelQuantity -= fuelNeeded;
    }

    protected void refuel(double quantity){
        this.fuelQuantity += quantity;
    }

    protected boolean hasEnoughFuel(double distance){
        double fuelNeeded = distance * this.fuelConsumption;
        boolean result = false;
        if (this.fuelQuantity >= fuelNeeded){
            result = true;
        }
        return  result;
    }
}
