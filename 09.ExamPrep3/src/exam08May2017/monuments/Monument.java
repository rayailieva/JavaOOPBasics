package exam08May2017.monuments;

public abstract class Monument {
    private String name;
    private int powerBoost;

    protected Monument(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getPowerBoost() {
        return this.powerBoost;
    }

    private void setPowerBoost(int powerBoost) {
        this.powerBoost = powerBoost;
    }

    protected void changePowerBoost(int powerBoost){
        this.setPowerBoost(powerBoost);
    }
}
