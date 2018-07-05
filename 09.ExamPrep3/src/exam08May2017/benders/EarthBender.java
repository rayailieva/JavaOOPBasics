package exam08May2017.benders;

public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
        super.changeTotalPower(power * groundSaturation);
    }

    public double getGroundSaturation() {
        return this.groundSaturation;
    }

    public void setGroundSaturation(double groundSaturation) {
        this.groundSaturation = groundSaturation;
    }

    @Override
    public String toString() {
        return String.format("###Earth Bender: %s, Power: %s, Ground Saturation: %.2f%n", super.getName(), super.getPower(), this.getGroundSaturation());
    }
}
