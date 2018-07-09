package app.entities.antiHeroes;

public class Villain extends AntiHero {
    private double attackPower;

    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
        this.attackPower = (super.getIntelligence() * super.getSpecial()) / super.getEnergy();
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
        sb.append(String.format("###Villain Attack Power: %.2f%n", this.attackPower));

        return sb.toString();
    }
}
