package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();

        while(!input.equals("End")){
            String[] animalData = input.split(" ");
            Animal animal = createAnimal(animalData);

            String[] foodData = scanner.nextLine().split(" ");
            Food food = createFood(foodData);

            if(animal != null){
                System.out.println(animal.makeSound());
                if(food != null){
                    try {
                        animal.eat(food);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                animals.add(animal);
            }

            input = scanner.nextLine();
        }

        for(Animal animal : animals){
            System.out.println(animal);
        }
    }

    public static Animal createAnimal(String[] animalTokens) {
        Animal animal = null;

        String type = animalTokens[0];
        String name = animalTokens[1];
        double weight = Double.parseDouble(animalTokens[2]);
        String livingRegion = animalTokens[3];

        switch (type) {

            case "Cat":
                animal = new Cat(name, type, weight,0, livingRegion, animalTokens[4]);
                break;
            case "Tiger":
                animal = new Tiger(name, type, weight, 0, livingRegion);
                break;
            case "Mouse":
                animal = new Mouse(name, type, weight, 0, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(name, type, weight, 0, livingRegion);
                break;

            default:return null;
        }
        return animal;
    }

    public static Food createFood(String[] foodTokens) {
        Food food = null;

        switch (foodTokens[0]) {
            case "Vegetable":
                food = new Vegetable(Integer.parseInt(foodTokens[1]));
                break;
            case "Meat":
                food = new Meat(Integer.parseInt(foodTokens[1]));
                break;
            default:return null;
        }
        return food;
    }
}

