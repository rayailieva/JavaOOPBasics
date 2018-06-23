package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    protected String livingRegion;


    public Mammal(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(), df.format(this.getAnimalWeight()), this.livingRegion, this.getFoodEaten());
    }
}
