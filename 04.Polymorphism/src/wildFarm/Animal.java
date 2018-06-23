package wildFarm;

public abstract class Animal {
    protected String animalName;
    protected String animalType;
    protected double animalWeight;
    protected int foodEaten;

    public Animal(String animalName, String animalType, double animalWeight, int foodEaten) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = foodEaten;
    }

    public String getAnimalName() {
        return this.animalName;
    }

    public String getAnimalType() {
        return this.animalType;
    }

    public double getAnimalWeight() {
        return this.animalWeight;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    public abstract String makeSound();

    public void eat(Food food){
        this.foodEaten += food.getQuantity();
    }
}
