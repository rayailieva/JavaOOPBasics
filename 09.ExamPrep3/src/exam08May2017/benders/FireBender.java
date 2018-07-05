package exam08May2017.benders;

public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
        super.changeTotalPower(power * heatAggression);
    }

    public double getHeatAggression() {
        return this.heatAggression;
    }

    public void setHeatAggression(double heatAggression) {
        this.heatAggression = heatAggression;
    }

    @Override
    public String toString() {
        return String.format("###Fire Bender: %s, Power: %s, Heat Aggression: %.2f%n", super.getName(), super.getPower(), this.getHeatAggression());
    }
}
