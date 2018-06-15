package shoppingSpree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String[] allPeople = scanner.nextLine().split(";");


        String[] allProducts = scanner.nextLine().split(";");



        String input = scanner.nextLine();
        while (!input.equals("END")){




            input = scanner.nextLine();
        }
    }
}
