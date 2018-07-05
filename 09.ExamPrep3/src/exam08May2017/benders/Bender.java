package exam08May2017.benders;

public abstract class Bender {
    private String name;
    private int power;
    private double totalPower;


    protected Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return this.power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    public double getTotalPower() {
        return this.totalPower;
    }

    private void setTotalPower(double totalPower) {
        this.totalPower = totalPower;
    }

    protected void changeTotalPower(double totalPower){
        this.setTotalPower(totalPower);
    }
}
