package exam08May2017.monuments;

public class FireMonument extends Monument {
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
        this.changePowerBoost(fireAffinity);
    }

    public int getFireAffinity() {
        return this.fireAffinity;
    }

    public void setFireAffinity(int fireAffinity) {
        this.fireAffinity = fireAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Fire Monument: %s, Fire Affinity: %s%n", super.getName(), this.getFireAffinity());
    }
}
