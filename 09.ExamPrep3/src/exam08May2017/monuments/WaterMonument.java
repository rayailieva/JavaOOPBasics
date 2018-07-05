package exam08May2017.monuments;

public class WaterMonument extends Monument {
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
        this.changePowerBoost(waterAffinity);
    }

    public int getWaterAffinity() {
        return this.waterAffinity;
    }

    public void setWaterAffinity(int waterAffinity) {
        this.waterAffinity = waterAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Water Monument: %s, Water Affinity: %s%n", super.getName(), this.getWaterAffinity());
    }
}
