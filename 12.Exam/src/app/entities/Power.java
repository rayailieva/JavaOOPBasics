package app.entities;

import app.interfaces.SuperPower;

import java.util.regex.Pattern;

public class Power implements SuperPower {
    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        String regex = "@[A-z-]{5,}@";
        if(Pattern.matches(regex, name)){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }

    }

    public double getPowerPoints() {
        return (this.powerPoints) + (this.name.length() / 2);
    }

    private void setPowerPoints(double powerPoints) {

        if(powerPoints < 0){
            throw new IllegalArgumentException("Power points should be a possitive number!");
        }
        this.powerPoints = powerPoints;
    }

    @Override
    public String toString() {
        return "Power{" +
                "name='" + name + '\'' +
                ", powerPoints=" + powerPoints +
                '}';
    }
}
