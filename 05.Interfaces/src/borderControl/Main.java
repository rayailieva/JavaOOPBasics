package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!input.equals("End")){
            String[] tokens = input.split(" ");

            if(tokens.length == 2){
                String model = tokens[0];
                String id = tokens[1];

                Identifiable robot = new Robot(model,id);
                identifiables.add(robot);

            }else if(tokens.length == 3){
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                Identifiable citizen = new Citizen(name, age , id);
                identifiables.add(citizen);
            }
            input = scanner.nextLine();
        }

        String fakeIdDigits = scanner.nextLine();

        for(Identifiable el : identifiables){
            if(el.getId().endsWith(fakeIdDigits)){
                System.out.println(el.getId());
            }
        }
    }
}
