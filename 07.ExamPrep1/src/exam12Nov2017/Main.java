package exam12Nov2017;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HealthManager healthManager = new HealthManager();

        while (!input.equals("BEER IS COMING")){

            String[] commands = input.split(" ");
            switch (commands[0])  {
                case "checkCondition":
                    System.out.print(healthManager.checkCondition(commands[1]));
                    break;
                case "createOrganism":
                    System.out.print(healthManager.createOrganism(commands[1]));
                    break;
                case "addCluster":
                    System.out.print(healthManager.addCluster(commands[1], commands[2],
                            Integer.parseInt(commands[3]), Integer.parseInt(commands[4])));
                    break;
                case "addCell":
                    System.out.print(healthManager.addCell(commands[1], commands[2], commands[3], commands[4],
                            Integer.parseInt(commands[5]), Integer.parseInt(commands[6]),
                            Integer.parseInt(commands[7]), Integer.parseInt(commands[8])));
                    break;
                case "activateCluster":
                    System.out.print(healthManager.activateCluster(commands[1]));
                    break;
                default:break;
            }
            input = scanner.nextLine();
        }
    }
}
