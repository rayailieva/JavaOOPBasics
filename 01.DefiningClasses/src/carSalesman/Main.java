package carSalesman;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedList<Engine> engines = new LinkedList<>();
        LinkedList<Car>cars = new LinkedList<>();

        for(int i = 0; i < n; i++){
            String[] engineData = scanner.nextLine().split(" ");

            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            int displacement = 0;
            String efficiency = "n/a";

            if(engineData.length == 3){
                String unknown = engineData[2];
                try {
                    displacement = Integer.parseInt(unknown);
                } catch (Exception ex) {
                    efficiency = unknown;
                }
            }
            if(engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            }

            Engine engine = new Engine(model,power,displacement,efficiency);
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < m; i++){
            String[] carData = scanner.nextLine().split(" ");

            String model = carData[0];
            String engineModel = carData[1];
            int weight = 0;
            String color = "n/a";

            Engine engine = null;

            for (Engine engine1 : engines) {
                if (engine1.getModel().equals(engineModel)){
                    engine = engine1;
                    break;
                }
            }

            if(carData.length == 3){
                String unknown = carData[2];
                try {
                    weight = Integer.parseInt(unknown);
                } catch (Exception ex) {
                    color = unknown;
                }
            }
            if(carData.length == 4) {
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            }

            Car car = new Car(model, engine,weight, color);
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
