package mankind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] studentInfo = scanner.nextLine().split(" ");
        String[] workerInfo = scanner.nextLine().split(" ");

        Student student = null;

        String studentFirstName = studentInfo[0];
        String studentLastName = studentInfo[1];
        String facultyNumber = studentInfo[2];

        try {
           student = new Student(studentFirstName, studentLastName, facultyNumber);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        Worker worker = null;

        String workerFirstName = workerInfo[0];
        String workerLastName = workerInfo[1];
        Double salary = Double.parseDouble(workerInfo[2]);
        Double workingHours = Double.parseDouble(workerInfo[3]);

        try {
            worker = new Worker(workerFirstName, workerLastName, salary, workingHours);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        if(student != null && worker != null) {
            System.out.println(student.toString());
            System.out.println(worker.toString());
        }
    }
}
