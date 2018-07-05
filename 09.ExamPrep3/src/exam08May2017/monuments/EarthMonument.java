package exam08May2017.monuments;

public class EarthMonument extends Monument {
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
        this.changePowerBoost(earthAffinity);
    }

    public int getEarthAffinity() {
        return this.earthAffinity;
    }

    public void setEarthAffinity(int earthAffinity) {
        this.earthAffinity = earthAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Earth Monument: %s, Earth Affinity: %s%n", super.getName(), this.getEarthAffinity());
    }
}
