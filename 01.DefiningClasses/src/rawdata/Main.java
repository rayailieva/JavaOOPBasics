package rawdata;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> result = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>() {{
                add(new Tire(tire1Pressure, tire1Age));
                add(new Tire(tire2Pressure, tire2Age));
                add(new Tire(tire3Pressure, tire3Age));
                add(new Tire(tire4Pressure, tire4Age));
            }};

            Car car = new Car(model, engine, cargo, tires);
            result.put(model, car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            result.entrySet().stream()
                    .filter(c -> c.getValue()
                            .getCargo()
                            .getCargoType()
                            .equals("fragile"))
                    .filter(c -> c.getValue()
                            .getTires()
                            .stream()
                            .filter(t -> t.getTirePressure() < 1)
                            .collect(Collectors.toList()).size() > 0)
                    .forEach(c -> System.out.println(c.getKey()));
        } else {
            result.entrySet().stream()
                    .filter(c -> c.getValue()
                            .getCargo()
                            .getCargoType()
                            .equals("flamable"))
                    .filter(c -> c.getValue()
                            .getEngine()
                            .getEnginePower() > 250)
                    .forEach(c -> System.out.println(c.getKey()));

        }
    }
}
