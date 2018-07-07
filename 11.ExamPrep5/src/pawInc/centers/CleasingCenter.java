package pawInc.centers;

import pawInc.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class CleasingCenter extends Center {
    private List<Animal> storedAnimals;
    private List<Animal> cleansedAnimals;

    public CleasingCenter(String name) {
        super(name);
        this.storedAnimals = new ArrayList<>();
        this.cleansedAnimals = new ArrayList<>();
    }

    public List<Animal> getCleansedAnimals() {
        return this.cleansedAnimals;
    }

    public void setCleansedAnimals(List<Animal> cleansedAnimals) {
        this.cleansedAnimals = cleansedAnimals;
    }

    public int getAnimalsWaitingCount(){
        return this.storedAnimals.size();
    }

    public void changeCleasingStatus(){
        for(Animal animal : this.getStoredAnimals()){
            animal.setCleansingStatus("cleansed");
            this.cleansedAnimals.add(animal);
        }
    }

    public String cleansedPrint(){
        StringBuilder sb = new StringBuilder();

        for(Animal animal : this.getCleansedAnimals()){
            sb.append(animal.getName() + ", ");
        }

        return sb.toString().substring(0, sb.length() - 2);
    }

    public List<Animal> getStoredAnimals() {
        return this.storedAnimals;
    }

    private void setStoredAnimals(List<Animal> storedAnimals) {
        this.storedAnimals = storedAnimals;
    }

    public void returnToAdoption() {

    }
}
