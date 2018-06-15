package classBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = null;

        try {
            box = new Box(length, width, height);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        if(box != null) {
            System.out.printf("Surface Area - %.2f \n", box.getSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f \n", box.getLateralSurfaceArea());
            System.out.printf("Volume - %.2f \n", box.getVolume());
         }
    }
}
