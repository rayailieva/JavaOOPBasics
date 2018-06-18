package shoppingSpree;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Product> products = new LinkedHashMap<>();
        LinkedHashMap<String, Person> people = new LinkedHashMap<>();

        String[] allPeople = scanner.nextLine().split("[;]");

        for(String p : allPeople){
            String[] tokens = p.split("=");
            String personName = tokens[0];
            double money = Double.parseDouble(tokens[1]);

            try{
                Person person = new Person(personName, money);
                people.put(personName, person);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String[] allProducts = scanner.nextLine().split("[;]");

        for(String p : allProducts){
            String[] tokens = p.split("=");
            String productName = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            try{
                Product product = new Product(productName,price);
                products.put(productName, product);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("END")){

            String[] tokens = input.split(" ");
            String personName = tokens[0];
            String productName = tokens[1];

            try{
                people.get(personName).addToCart(products.get(productName));
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }

        for (var p : people.entrySet()) {
            System.out.println(p.getValue());
        }


    }
}
