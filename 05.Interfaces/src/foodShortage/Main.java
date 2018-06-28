package foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Buyer> buyers = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] tokens = scanner.nextLine().split(" ");

            if(tokens.length == 4){
                Buyer citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                buyers.add(citizen);

            }else if(tokens.length == 3){
                Buyer rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                buyers.add(rebel);
            }
        }

        while (true){
            String name = scanner.nextLine();

            if(name.equals("End")){
                break;
            }

            if(buyers.stream().anyMatch(x -> x.getName().equals(name))){
                Buyer temp = buyers.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
                temp.buyFood();
            }
        }
        System.out.println(buyers.stream().mapToInt(Buyer::getFood).sum());
    }
}
