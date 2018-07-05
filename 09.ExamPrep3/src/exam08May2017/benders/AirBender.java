package exam08May2017.benders;

public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
        super.changeTotalPower(power * aerialIntegrity);
    }

    public double getAerialIntegrity() {
        return this.aerialIntegrity;
    }

    public void setAerialIntegrity(double aerialIntegrity) {
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public String toString() {
        return String.format("###Air Bender: %s, Power: %s, Aerial Integrity: %.2f%n", super.getName(), super.getPower(), this.getAerialIntegrity());
    }
}
