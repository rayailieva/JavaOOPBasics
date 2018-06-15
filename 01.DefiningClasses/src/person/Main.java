package person;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> people = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++){
            String[] personData = scanner.nextLine().split(" ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person person = new Person(name, age);

            if(person.getAge() > 30){
                people.put(person.getName(), person.getAge());
            }
        }

        for(var entry : people.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
