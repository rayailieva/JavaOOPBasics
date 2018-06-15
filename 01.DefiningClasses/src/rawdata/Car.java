package rawdata;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distance;
    private double possibleDistance;
    private String result;

    Car(String model, double fuelAmount, double fuelCostPerKm){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;

        this.distance = 0;
        this.setPossibleDistance();
        this.result = "";
    }

    private void setPossibleDistance(){
        possibleDistance = this.fuelAmount / this.fuelCostPerKm;
    }

}
