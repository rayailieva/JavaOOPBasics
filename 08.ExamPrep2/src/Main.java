import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        CarManager manager = new CarManager();

        while (!input.equals("Cops Are Here")){
            String[] tokens = scanner.nextLine().split(" ");

            String command = tokens[0];

            switch (command){
                case "register":
                    manager.register(Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9]));
                    break;
                case "check":
                    System.out.println(manager.check(Integer.parseInt(tokens[1])));
                    break;
                case "open":
                    manager.open(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), tokens[4], Integer.parseInt(tokens[5]));
                    break;
                case "participate":
                    manager.participate(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "start":
                    manager.start(Integer.parseInt(tokens[1]));
                    break;
                case "park":
                    manager.park(Integer.parseInt(tokens[1]));
                    break;
                case "unpark":
                    manager.unpark(Integer.parseInt(tokens[1]));
                    break;
                case "tune":
                    manager.tune(Integer.parseInt(tokens[1]), tokens[2]);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}

