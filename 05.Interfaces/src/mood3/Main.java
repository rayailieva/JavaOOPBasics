package mood3;

import mood3.implementation.ArchangelImpl;
import mood3.implementation.DemonImpl;
import mood3.interfaces.Hero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" \\| ");

        Hero hero = createHero(tokens);

        System.out.println(hero);
    }

    private static Hero createHero(String[] inTokens) {
        String username = inTokens[0];
        String type = inTokens[1];
        int level = Integer.parseInt(inTokens[3]);

        Hero hero = null;
        
        if ("Demon".equals(type)) {
            double energy = Double.parseDouble(inTokens[2]);
            hero = new DemonImpl(username, energy, level);
        } else {
            int mana = Integer.parseInt(inTokens[2]);
            hero = new ArchangelImpl(username, mana, level);
        }
        return hero;
    }
}
