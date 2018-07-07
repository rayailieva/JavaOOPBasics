package pawInc;

import pawInc.animals.Animal;
import pawInc.animals.Cat;
import pawInc.animals.Dog;
import pawInc.centers.AdoptionCenter;
import pawInc.centers.Center;
import pawInc.centers.CleasingCenter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnimalCenterManager {
    private Map<String, CleasingCenter> cleansingCenters;
    private Map<String, AdoptionCenter> adoptionCenters;

    private List<String> adoptedAnimals;


    public AnimalCenterManager() {
        this.cleansingCenters = new LinkedHashMap<>();
        this.adoptionCenters = new LinkedHashMap<>();
        this.adoptedAnimals = new ArrayList<>();
    }


    public Map<String, CleasingCenter> getCleansingCenters() {
        return this.cleansingCenters;
    }

    public void setCleansingCenters(Map<String, CleasingCenter> cleansingCenters) {
        this.cleansingCenters = cleansingCenters;
    }

    public Map<String, AdoptionCenter> getAdoptionCenters() {
        return this.adoptionCenters;
    }

    public void setAdoptionCenters(Map<String, AdoptionCenter> adoptionCenters) {
        this.adoptionCenters = adoptionCenters;
    }

    public void registerCleansingCenter(String name){
        CleasingCenter center = new CleasingCenter(name);
        this.cleansingCenters.put(name, center);
   }

    public void registerAdoptionCenter(String name){
       AdoptionCenter center = new AdoptionCenter(name);
       this.adoptionCenters.put(name, center);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName){
        Dog dog = new Dog(name, age, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).addDog(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
        Cat cat = new Cat(name, age, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).addCat(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){
        AdoptionCenter adoptionCenter = adoptionCenters.get(adoptionCenterName);
        Center cleansingCenter = cleansingCenters.get(cleansingCenterName);

        adoptionCenter.addAnimalsForCleansing();

        for(Animal animal: adoptionCenter.getUncleansedAnimals()){
            cleansingCenter.getStoredAnimals().add(animal);
            //adoptionCenter.getStoredAnimals().remove(animal);
        }

    }

    public void cleanse(String cleansingCenterName){
        CleasingCenter center = cleansingCenters.get(cleansingCenterName);

        center.changeCleasingStatus();
    }

    public void adopt(String adoptionCenterName){
        Center center = adoptionCenters.get(adoptionCenterName);

        for(Animal animal : center.getStoredAnimals()){
            if(animal.getCleansingStatus().equals("cleansed")){
                adoptedAnimals.add(animal.getName());
                center.getStoredAnimals().remove(animal);
            }
        }

    }


    public String printStatistics(){
        StringBuilder sb = new StringBuilder();

        sb.append("Paw Incorporative Regular Statistics").append("\n");
        sb.append(String.format("Adoption Centers: %d", this.adoptionCenters.size())).append("\n");
        sb.append(String.format("Cleansing Centers: %d", this.cleansingCenters.size())).append("\n");
        sb.append("Adopted Animals: ");
            for(String name : adoptedAnimals){
                sb.append(name).append(", ");
            }
                sb.append("\n");

        sb.append("Cleansed Animals: ").append("\n");
        sb.append("Animals Awaiting Adoption: ").append(this.adoptionCenters.values().stream().mapToInt(AdoptionCenter::getToBeAdopted).sum()).append("\n");
        sb.append("Animals Awaiting Cleansing: ").append(this.cleansingCenters.values().stream().mapToInt(CleasingCenter::getAnimalsWaitingCount).sum());

        return sb.toString();
    }

}
