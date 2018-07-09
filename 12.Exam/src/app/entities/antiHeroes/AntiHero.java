package app.entities.antiHeroes;

import app.entities.ComicCharacterImpl;

public class AntiHero extends ComicCharacterImpl {
   private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }


    private void setEvilness(double evilness) {
        if(evilness < 0){
            throw new IllegalArgumentException("Evilness should be a possitive number!");
        }
        this.evilness = evilness;
    }

   public double getSpecial(){
        return this.evilness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(String.format("###Evilness:%.2f%n", this.getSpecial()));

        return sb.toString();
    }
}
