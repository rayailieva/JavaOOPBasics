package carSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        Engine eng = this.getEngine();

        if (eng.getDisplacement() <= 0 && this.weight > 0) {
            return String.format("%s:%n  %s:%n    Power: %s%n    Displacement: n/a%n    Efficiency: %s%n    Weight: %s%n    Color: %s",
                    this.model, eng.getModel(), eng.getPower(), eng.getEfficiency(), this.weight, this.color);
        }

        if (eng.getDisplacement() <= 0 && this.weight <= 0) {
            return String.format("%s:%n  %s:%n    Power: %s%n    Displacement: n/a%n    Efficiency: %s%n    Weight: n/a%n    Color: %s",
                    this.model, eng.getModel(), eng.getPower(), eng.getEfficiency(), this.color);
        }
        if (eng.getDisplacement() > 0 && this.weight <= 0) {
            return String.format("%s:%n  %s:%n    Power: %s%n    Displacement: %s%n    Efficiency: %s%n    Weight: n/a%n    Color: %s",
                    this.model, eng.getModel(), eng.getPower(), eng.getDisplacement(), eng.getEfficiency(), this.color);
        }

        return String.format("%s:%n  %s:%n    Power: %s%n    Displacement: %s%n    Efficiency: %s%n    Weight: %s%n     Color: %s",
                this.model, eng.getModel(), eng.getPower(), eng.getDisplacement(), eng.getEfficiency(), this.weight, this.color);
    }
}


