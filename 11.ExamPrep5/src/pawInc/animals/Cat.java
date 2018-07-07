package pawInc.animals;

public class Cat extends Animal {
    private String cleansingStatus;
    private int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient) {
        super(name, age);
        this.setCleansingStatus("uncleansed");
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public int getIntelligenceCoefficient() {
        return this.intelligenceCoefficient;
    }

    private void setIntelligenceCoefficient(int intelligenceCoefficient) {
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public String getCleansingStatus() {
        return this.cleansingStatus;
    }

    public void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }


}
