package pawInc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AnimalCenterManager manager = new AnimalCenterManager();

        String input = scanner.nextLine();

        while (!input.equals("Paw Paw Pawah")){
            String[] tokens = input.split(" \\| ");
            String command = tokens[0];

            switch (command){
                case "RegisterCleansingCenter":
                    manager.registerCleansingCenter(tokens[1]);
                    break;
                case "RegisterAdoptionCenter":
                    manager.registerAdoptionCenter(tokens[1]);
                    break;
                case "RegisterCat":
                    manager.registerCat(tokens[1],Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), tokens[4]);
                    break;
                case "RegisterDog":
                    manager.registerDog(tokens[1],Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), tokens[4]);
                    break;
                case "SendForCleansing":
                    manager.sendForCleansing(tokens[1], tokens[2]);
                    break;
                case "Cleanse":
                    manager.cleanse(tokens[1]);
                    break;
                case "Adopt":
                    manager.adopt(tokens[1]);
                    break;

                    default:break;
            }

            input = scanner.nextLine();
        }
        System.out.println(manager.printStatistics());
    }
}
