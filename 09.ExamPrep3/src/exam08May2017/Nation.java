package exam08May2017;

import exam08May2017.benders.Bender;
import exam08May2017.monuments.Monument;

import java.util.ArrayList;
import java.util.List;

public class Nation {
    private String name;
    private List<Bender> benders;
    private List<Monument> monuments;
    private double totalPower;

    public Nation(String name) {
        this.name = name;
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
        this.setTotalPower(0);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Bender> getBenders() {
        return this.benders;
    }

    private void setBenders(List<Bender> benders) {
        this.benders = benders;
    }

    public List<Monument> getMonuments() {
        return this.monuments;
    }

    private void setMonuments(List<Monument> monuments) {
        this.monuments = monuments;
    }

    public double getTotalPower() {
        return this.totalPower;
    }

    private void setTotalPower(double totalPower) {
        this.totalPower = totalPower;
    }

    public void calculateTotalPower(){

        double benderPower = benders.stream().mapToDouble(Bender::getTotalPower).sum();
        int monumentBoost = monuments.stream().mapToInt(Monument::getPowerBoost).sum();
        double result = (benderPower / 100) * monumentBoost + benderPower;
        this.setTotalPower(result);
    }

    public void addBender(Bender bender){
        this.getBenders().add(bender);
    }
    public void addMonument(Monument monument){
        this.getMonuments().add(monument);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" ").append("Nation\n").append("Benders:");
        if (benders.isEmpty()){
            sb.append(" None\n");
        }else{
            sb.append("\n");
            for (Bender bender: benders){
                sb.append(bender.toString());
            }
        }
        sb.append("Monuments:");
        if (monuments.isEmpty()){
            sb.append(" None\n");
        }else{
            sb.append("\n");
            for (Monument monument: monuments){
                sb.append(monument.toString());
            }
        }
        return sb.toString();
    }
}
