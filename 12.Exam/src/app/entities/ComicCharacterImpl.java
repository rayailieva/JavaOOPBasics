package app.entities;

import app.interfaces.ComicCharacter;
import app.interfaces.SuperPower;

import java.util.ArrayList;
import java.util.List;

public class ComicCharacterImpl implements ComicCharacter {
    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;

    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.setPowers(new ArrayList<>());
        }


    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name.length() < 2 || name.length() > 12){
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        }
        this.name = name;
    }

    public int getEnergy() {
        return this.energy;
    }

    private void setEnergy(int energy) {
        if(energy < 0 || energy > 300){
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }
        this.energy = energy;
    }

    public double getHealth() {
        return this.health;
    }

    private void setHealth(double health) {
        if(health < 0){
            throw new IllegalArgumentException("Health should be a possitive number!");
        }
        this.health = health;
    }

    public double getIntelligence() {
        return this.intelligence;
    }


    private void setIntelligence(double intelligence) {
        if(intelligence < 0 || intelligence > 200){
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
        this.intelligence = intelligence;
    }

    public List<SuperPower> getPowers() {
        return this.powers;
    }

    private void setPowers(List<SuperPower> powers) {
        this.powers = powers;
    }

    @Override
    public void takeDamage(double damage) {
        this.health = this.health - damage;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        if(energy >= 0 && energy <= 300){
            this.energy = energy;
        }
        if(health >= 0){
            this.health = health;
        }
        if(intelligence >= 0 && intelligence <= 200){
            this.intelligence = intelligence;
        }
    }

    @Override
    public double attack() {
        return 0;
    }

    @Override
    public double getSpecial() {
        return 0;
    }

    @Override
    public String useSuperPowers() {
        if(this.getPowers().size() == 0){
            return String.format("%s has no super powers!%n", this.getName());
        }
        for(SuperPower superPower : powers){
            this.energy = (this.energy + (int)superPower.getPowerPoints());
            this.health = (this.health + (superPower.getPowerPoints() * 2));
        }
        return String.format("%s used his super powers!%n", this.getName());
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.powers.add(superPower);
    }

    @Override
    public List<SuperPower> getSuperPowers() {
        return this.powers;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();

       sb.append(String.format("#Name: %s%n", this.name));
       sb.append(String.format("##Health: %.2f//Energy: %d//Intelligence: %.2f%n", this.health, this.energy, this.intelligence));

       return sb.toString();
    }
}
