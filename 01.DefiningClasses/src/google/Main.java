package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] inputs = input.split(" ");
            String name = inputs[0];
            people.putIfAbsent(name, new Person(name));
            Person person = people.get(name);
            String command = inputs[1];

            switch (command){
                case "company":
                    String companyName = inputs[2];
                    String department = inputs[3];
                    double salary = Double.parseDouble(inputs[4]);
                    person.updateCompany(companyName, department, salary);
                    break;
                case "car":
                    String model = inputs[2];
                    int speed = Integer.parseInt(inputs[3]);
                    person.updateCar(model, speed);
                    break;
                case "parents":
                    String parentName = inputs[2];
                    String parentBirthday = inputs[3];
                    person.addParent(parentName, parentBirthday);
                    break;
                case "children":
                    String childName = inputs[2];
                    String childBirthday = inputs[3];
                    person.addChild(childName, childBirthday);
                    break;
                case "pokemon":
                    String pokemonName = inputs[2];
                    String type = inputs[3];
                    person.addPokemon(pokemonName, type);
                    break;
            }
            input = scanner.nextLine();
        }
        String nameToPrint = scanner.nextLine();
        System.out.print(people.get(nameToPrint));
    }
}
