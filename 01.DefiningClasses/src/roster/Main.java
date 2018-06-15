package roster;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Department> result = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");

            String name = input[0];
            Double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            String email = "n/a";
            int age = -1;

            if(input.length == 5){
                String unknown = input[4];
                try {
                    age = Integer.parseInt(unknown);
                } catch (Exception ex) {
                    email = unknown;
                }
            }
            if(input.length == 6){
                email = input[4];
                age = Integer.parseInt(input[5]);
            }

            Employee employee = new Employee(name,salary,position,department,email,age);

            result.putIfAbsent(department, new Department(department));
            result.get(department).addEmployees(employee);
        }

        StringBuilder sb = new StringBuilder();

        result.entrySet().stream()
                .sorted((d1, d2) -> {
                    double d1Average = d1.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    double d2Average = d2.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble();

                    return Double.compare(d2Average, d1Average);
                })
                .limit(1)
                .forEach(d -> {
                    sb.append("Highest Average Salary: ").append(d.getKey()).append(System.lineSeparator());

                    d.getValue().getEmployees().stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(e -> sb
                                    .append(String.format("%s %.2f %s %d"
                                            , e.getName()
                                            , e.getSalary()
                                            , e.getEmail()
                                            , e.getAge()))
                                    .append(System.lineSeparator()));
                });

        System.out.println(sb);
    }
}
