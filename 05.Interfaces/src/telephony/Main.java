package telephony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> webSites = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone();

        for(String number : numbers){
            if(checkIfNumber(number)){
                System.out.println(smartphone.call(number));
            }else{
                System.out.println("Invalid number!");
            }
        }

        for (String webSite: webSites){
            if(checkIfNotNumber(webSite)){
                System.out.println(smartphone.browse(webSite));
            }else{
                System.out.println("Invalid URL!");
            }
        }
    }

    public static boolean checkIfNumber(String number){
        for (int i = 0; i < number.length(); i++){
            if(!Character.isDigit(number.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static boolean checkIfNotNumber(String webSite){
        for (int i = 0; i < webSite.length(); i++){
            if(Character.isDigit(webSite.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
