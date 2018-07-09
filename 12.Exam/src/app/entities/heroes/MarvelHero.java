package app.entities.heroes;

public class MarvelHero extends Hero {
    private double attackPower;

    public MarvelHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
        this.attackPower = ((super.getEnergy() + super.getSpecial())* super.getIntelligence())/2.5;
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
        sb.append(String.format("###Marvel Attack Power: %.2f%n", this.attackPower));

        return sb.toString();
    }
}
