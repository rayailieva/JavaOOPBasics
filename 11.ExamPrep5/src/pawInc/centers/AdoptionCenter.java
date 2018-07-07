package pawInc.centers;

import pawInc.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class AdoptionCenter extends Center {

    private List<Animal> storedAnimals;
    private List<Animal> uncleansedAnimals = new ArrayList<>();

    public AdoptionCenter(String name) {
        super(name);
        this.storedAnimals = new ArrayList<>();
    }

    public int getToBeAdopted(){
        return this.getStoredAnimals().size();
    }

    public List<Animal> getStoredAnimals() {
        return this.storedAnimals;
    }

    private void setStoredAnimals(List<Animal> storedAnimals) {
        this.storedAnimals = storedAnimals;
    }

    public List<Animal> getUncleansedAnimals() {
        return this.uncleansedAnimals;
    }

    public void setUncleansedAnimals(List<Animal> uncleansedAnimals) {
        this.uncleansedAnimals = uncleansedAnimals;
    }

    public void addAnimalsForCleansing(){
        for(Animal animal : this.storedAnimals){
            if(animal.getCleansingStatus().equals("uncleansed")){
                uncleansedAnimals.add(animal);
            }
        }
    }

    public void adoptAnimal(){

    }

}
