package pawInc.centers;

import pawInc.animals.Animal;
import pawInc.animals.Cat;
import pawInc.animals.Dog;

import java.util.ArrayList;
import java.util.List;

public abstract class Center {
    private String name;
    private List<Animal> storedAnimals;

    public Center(String name) {
        this.name = name;
        this.storedAnimals = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Animal> getStoredAnimals() {
        return this.storedAnimals;
    }

    private void setStoredAnimals(List<Animal> storedAnimals) {
        this.storedAnimals = storedAnimals;
    }

    public void addDog(Dog dog) {
        this.getStoredAnimals().add(dog);
    }

    public void addCat(Cat cat) {
        this.getStoredAnimals().add(cat);
    }
}
