package app.entities.antiHeroes;

public class Titan extends AntiHero {
    private double attackPower;

    public Titan(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
        this.attackPower = (super.getEnergy() + super.getIntelligence() + super.getSpecial()) * 3;
    }

    public double getAttackPower() {
        return this.attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("###Titan Attack Power: %.2f%n", this.attackPower));

        return sb.toString();
    }
}
