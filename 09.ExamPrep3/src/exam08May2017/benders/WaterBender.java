package exam08May2017.benders;

public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
        super.changeTotalPower(power * waterClarity);
    }

    public double getWaterClarity() {
        return this.waterClarity;
    }

    public void setWaterClarity(double waterClarity) {
        this.waterClarity = waterClarity;
    }

    @Override
    public String toString() {
        return String.format("###Water Bender: %s, Power: %s, Water Clarity: %.2f%n", super.getName(), super.getPower(), this.getWaterClarity());
    }
}
