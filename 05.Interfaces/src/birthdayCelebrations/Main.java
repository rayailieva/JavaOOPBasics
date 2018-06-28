package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Living> living = new ArrayList<>();

        while (!input.equals("End")){
            String[] tokens = input.split(" ");

            if(tokens[0].equals("Robot")){
                String model = tokens[0];
                String id = tokens[1];

                Identifiable robot = new Robot(model,id);


            }else if(tokens[0].equals("Pet")){
                String name = tokens[1];
                String birthday = tokens[2];

                Living pet = new Pet(name, birthday);
                living.add(pet);

            }else if(tokens[0].equals("Citizen")){
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthday = tokens[4];

                Living citizen = new Citizen(name, age , id, birthday);
                living.add(citizen);

            }
            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for(Living el : living){
            if(el.getBirthday().endsWith(year)){
                System.out.println(el.getBirthday());
            }
        }
    }
}
