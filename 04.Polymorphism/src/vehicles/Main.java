package vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carLitersPerKm = Double.parseDouble(carInfo[2]);

        Vehicle car = new Car(carFuelQuantity,carLitersPerKm);

        String[] truckInfo = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckLitersPerKm = Double.parseDouble(truckInfo[2]);

        Vehicle truck = new Truck(truckFuelQuantity, truckLitersPerKm);

        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++){

            DecimalFormat df = new DecimalFormat("0.##");

            String[] commands = scanner.nextLine().split(" ");

            String command = commands[0];
            String vehicleType = commands[1];
            double distanceOrFuel = Double.parseDouble(commands[2]);

            if(vehicleType.equals("Car")){
                if(command.equals("Drive")){
                    if(car.hasEnoughFuel(distanceOrFuel)){
                        car.drive(distanceOrFuel);
                        System.out.printf("Car travelled %s km\n", df.format(distanceOrFuel));
                    }else{
                        System.out.println("Car needs refueling");
                    }
                }else if(command.equals("Refuel")){
                    car.refuel(distanceOrFuel);
                }
            }else if(vehicleType.equals("Truck")){
                if(command.equals("Drive")){
                    if(truck.hasEnoughFuel(distanceOrFuel)){
                        truck.drive(distanceOrFuel);
                        System.out.printf("Truck travelled %s km\n", df.format(distanceOrFuel));
                    }else{
                        System.out.println("Truck needs refueling");
                    }
                }else if(command.equals("Refuel")){
                    truck.refuel(distanceOrFuel);
                }
            }

        }

        System.out.printf("Car: %.2f\n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());

    }
}
