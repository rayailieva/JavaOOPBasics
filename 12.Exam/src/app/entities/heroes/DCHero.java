package app.entities.heroes;

public class DCHero extends Hero {
    private double attackPower;

    public DCHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
        this.attackPower = (super.getEnergy() / 1.5) + super.getSpecial() + super.getIntelligence();
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
        sb.append(String.format("###DC Attack Power: %.2f%n", this.attackPower));

        return sb.toString();
    }
}
